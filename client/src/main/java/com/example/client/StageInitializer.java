package com.example.client;

import com.example.client.GameUiApplication.StageReadyEvent;
import com.sun.javafx.fxml.BeanAdapter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("classpath:/menu.fxml")
    private Resource menuResource;
    private String applicationTitle;
    private ApplicationContext applicationContext;

    public StageInitializer(@Value("${spring.application.ui.title}")String applicationTitle) {
        this.applicationTitle = applicationTitle;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(menuResource.getURL());
            loader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
            Parent parent = loader.load();
            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 800, 600));

            stage.setTitle(applicationTitle);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
