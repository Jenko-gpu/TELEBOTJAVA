package io.proj3ct.TeleJava.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import io.proj3ct.TeleJava.config.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import io.proj3ct.TeleJava.sqlcontrol.Sqlcontroler;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class Telegrambot extends TelegramLongPollingBot {

    final Botconfig botconfig;

    public Telegrambot(Botconfig config){

        this.botconfig = config;
        Sqlcontroler sqlcontroler = new Sqlcontroler();
    }

    private ApplicationContext context;

    @Override
    public String getBotUsername() {
        return botconfig.getName();
    }

    @Override
    public String getBotToken() {
        return botconfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText){
                case "/start":
                    startCommand(chatId, update.getMessage());
                    break;
                default:
                    sendmessage(chatId,messageText);
                    break;
            }

        }
    }
    private void sendmessage(long chatId, String text){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            execute(message);
        }
        catch (TelegramApiException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void startCommand(long chatId, Message message) {
        String answer = "Hi, " + message.getChat().getFirstName() + ", I am alive!!!";
        sendmessage(chatId, answer);
    }
}
