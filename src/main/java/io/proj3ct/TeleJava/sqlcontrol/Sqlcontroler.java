package io.proj3ct.TeleJava.sqlcontrol;
import java.sql.*;
public class Sqlcontroler {
    // Блок объявления констант
    public static final String DB_URL = "jdbc:h2:C:\\\\Users\\\\Jenko_Mars\\\\Desktop\\\\JSSQUAD\\\\JSLEARNING\\\\TELEBOTJAVA\\\\src\\\\main\\\\database\\\\test";
    public static final String DB_Driver = "org.h2.Driver";
    Connection connection;
    public Sqlcontroler(){
        try {
            Class.forName(DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД
            connection = DriverManager.getConnection(DB_URL);//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");


        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
    }

    public void close(){
        try {
            if (!connection.isClosed()) {
                connection.close();       // отключение от БД
                System.out.println("Отключение от СУБД выполнено.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
    }

    public void createTable(){

    }
}
