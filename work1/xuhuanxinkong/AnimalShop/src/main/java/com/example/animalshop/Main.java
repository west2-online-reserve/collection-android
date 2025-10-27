package com.example.animalshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//      加载FXML
            URL fxmlUrl = getClass().getResource("/main.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            Parent root = loader.load();

            // 创建场景并显示
            Scene scene = new Scene(root, 600, 700);
            primaryStage.setTitle("宠物店管理系统");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}