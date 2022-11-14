package com.example.workshops_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.synedra.validatorfx.Validator;

import java.io.IOException;

public class StudentApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(StudentApplication.class.getResource("student-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 297);
        stage.setTitle("Student form validator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}