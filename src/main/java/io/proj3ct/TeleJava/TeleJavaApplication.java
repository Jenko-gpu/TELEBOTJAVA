package io.proj3ct.TeleJava;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.proj3ct.TeleJava.sqlcontrol.Sqlcontroler;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TeleJavaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TeleJavaApplication.class, args);
	}

}
