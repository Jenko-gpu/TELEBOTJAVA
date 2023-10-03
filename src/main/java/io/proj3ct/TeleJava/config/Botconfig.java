package io.proj3ct.TeleJava.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Data;

@Configuration
@Data
@PropertySource("application.properties")
public class Botconfig {

    @Value("${bot.name}")
    String name;

    @Value("${bot.key}")
    String token;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
