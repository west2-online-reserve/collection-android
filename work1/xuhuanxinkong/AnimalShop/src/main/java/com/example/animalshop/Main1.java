package com.example.animalshop;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main1 extends Application {
    private Stage primaryStage;
    private Scene mainScene;  // 缓存主界面场景
    private Scene buyScene;// 缓存买入界面场景
    private MyAnimalShop petShop;
    private MainController mainController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.petShop = new MyAnimalShop(1000.0);
        // 初始显示主界面
        switchToMain();
        primaryStage.setTitle("动物商店管理系统");
        primaryStage.show();

    }
    public MyAnimalShop getPetShop() {return petShop;}
    /**
     * 切换到主界面
     */
    public void switchToMain() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
            Parent mainRoot = loader.load();  // 加载 main.fxml 的根节点

            // 获取控制器并设置 Main1 实例
            MainController controller1 = loader.getController();
            controller1.setMain1(this);

            mainScene = new Scene(mainRoot, 600, 700);
            primaryStage.setScene(mainScene);
    }

    /**
     * 切换到买入动物界面
     */
    public void switchToBuy() throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/buy.fxml"));
            Parent buyRoot = loader.load();  // 加载 buy.fxml 的根节点

            // 获取买入界面的控制器并设置 Main1 实例
            BuyController controller = loader.getController();
            controller.setMain1(this);


            buyScene = new Scene(buyRoot, 600, 700);
        primaryStage.setScene(buyScene);
    }
}
