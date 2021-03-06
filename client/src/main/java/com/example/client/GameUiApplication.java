package com.example.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class GameUiApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    public void init(){
        applicationContext = new SpringApplicationBuilder(ClientApplication.class).run();
    }
    @Override
    public void start(Stage stage) throws Exception {
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    public void stop(){
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage){
            super(stage);
        }

        public Stage getStage(){
            return ((Stage) getSource());
        }
    }
}
