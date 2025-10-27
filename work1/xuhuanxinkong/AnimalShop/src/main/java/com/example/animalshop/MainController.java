package com.example.animalshop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private VBox mainContainer;

    @FXML
    private Button enterBtn;

    @FXML
    private VBox functionsBox;

    @FXML
    private TextArea outputArea;

    @FXML
    private Button buyAnimalBtn;

    @FXML
    private Button serveCustomerBtn;

    @FXML
    private Button viewAnimalsBtn;

    @FXML
    private Button viewCustomersBtn;

    @FXML
    private Button shopInfoBtn;

    @FXML
    private Button closeBusinessBtn;

    @FXML
    private Button buyDogBtn;

    @FXML
    private Button buyCatBtn;

    private MyAnimalShop petShop;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 初始化宠物店
        petShop = new MyAnimalShop(1000.0);

        // 设置初始文本
        outputArea.setText("🐾 欢迎使用宠物店管理系统！\n初始资金: 1000.0元\n请点击上方按钮开始操作...");

        // 添加按钮悬停效果
        setupButtonHoverEffects();
    }

    @FXML
    private void onEnterButtonClick() {
        boolean isVisible = functionsBox.isVisible();
        functionsBox.setVisible(!isVisible);
        enterBtn.setText(isVisible ? "进入宠物店管理系统" : "收起功能区");
    }

    @FXML
    private void onBuyAnimalClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 买入动物 ===\n");

        try {
            Animal dog = new ChineseRuralDog("小黑", 2, "公", true);
            Animal cat = new Cat("咪咪", 1, "母", "白色");


            petShop.purchaseAnimal(dog);
            sb.append("✅ 成功买入: ").append(dog).append("\n");

            petShop.purchaseAnimal(cat);
            sb.append("✅ 成功买入: ").append(cat).append("\n");



            sb.append("\n当前余额: ").append(petShop.getBalance()).append("元\n");
            sb.append("动物数量: ").append(petShop.getAnimalList().size()).append("只");

        } catch (InsufficientBalanceException e) {
            sb.append("❌ 买入失败: ").append(e.getMessage()).append("\n");
        } catch (Exception e) {
            sb.append("❌ 错误: ").append(e.getMessage()).append("\n");
        }

        outputArea.setText(sb.toString());
    }

    @FXML
    private void onServeCustomerClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 招待客户 ===\n");

        try {
            Customer customer1 = new Customer("张三");
            Customer customer2 = new Customer("李四");

            petShop.serveCustomer(customer1);
            sb.append("✅ 成功招待客户: ").append(customer1.getName()).append("\n");

            petShop.serveCustomer(customer2);
            sb.append("✅ 成功招待客户: ").append(customer2.getName()).append("\n");

            sb.append("\n当前余额: ").append(petShop.getBalance()).append("元\n");
            sb.append("剩余动物: ").append(petShop.getAnimalList().size()).append("只\n");
            sb.append("客户数量: ").append(petShop.getCustomerList().size()).append("位");

        } catch (AnimalNotFoundException e) {
            sb.append("❌ 招待失败: ").append(e.getMessage()).append("\n");
            sb.append("提示：请先买入动物！");
        } catch (Exception e) {
            sb.append("❌ 错误: ").append(e.getMessage()).append("\n");
        }

        outputArea.setText(sb.toString());
    }

    @FXML
    private void onViewAnimalsClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 店内动物列表 ===\n");

        var animals = petShop.getAnimalList();
        if (animals.isEmpty()) {
            sb.append("暂无动物\n");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                sb.append(i + 1).append(". ").append(animals.get(i)).append("\n");
            }
            sb.append("\n总计: ").append(animals.size()).append(" 只动物");
        }

        outputArea.setText(sb.toString());
    }

    @FXML
    private void onViewCustomersClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 客户列表 ===\n");

        var customers = petShop.getCustomerList();
        if (customers.isEmpty()) {
            sb.append("暂无客户记录\n");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                sb.append(i + 1).append(". ").append(customers.get(i)).append("\n");
            }
            sb.append("\n总计: ").append(customers.size()).append(" 位客户");
        }

        outputArea.setText(sb.toString());
    }

    @FXML
    private void onShopInfoClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 店铺信息 ===\n");
        sb.append("当前余额: ").append(petShop.getBalance()).append("元\n");
        sb.append("动物数量: ").append(petShop.getAnimalList().size()).append(" 只\n");
        sb.append("客户数量: ").append(petShop.getCustomerList().size()).append(" 位\n");
        sb.append("营业状态: ").append(petShop.isInBusiness() ? "营业中" : "已歇业").append("\n");
        sb.append("今日利润: ").append(petShop.getDailyProfit()).append("元");

        outputArea.setText(sb.toString());
    }

    @FXML
    private void onCloseBusinessClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 歇业结算 ===\n");

        try {
            petShop.closeBusiness();
            sb.append("✅ 歇业成功！\n");
            sb.append("当前余额: ").append(petShop.getBalance()).append("元\n");
            sb.append("明日重新开业");

        } catch (Exception e) {
            sb.append("❌ 歇业失败: ").append(e.getMessage()).append("\n");
        }

        outputArea.setText(sb.toString());
    }

    // 设置按钮悬停效果
    private void setupButtonHoverEffects() {
        setupHoverEffect(buyAnimalBtn, "#4CAF50", "#45a049");
        setupHoverEffect(serveCustomerBtn, "#2196F3", "#1976D2");
        setupHoverEffect(viewAnimalsBtn, "#9C27B0", "#7b1fa2");
        setupHoverEffect(viewCustomersBtn, "#FF9800", "#f57c00");
        setupHoverEffect(shopInfoBtn, "#607D8B", "#455a64");
        setupHoverEffect(closeBusinessBtn, "#F44336", "#d32f2f");
    }

    private void setupHoverEffect(Button button, String normalColor, String hoverColor) {
        String normalStyle = String.format("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10px 20px; " +
                "-fx-background-color: %s; -fx-text-fill: white; -fx-background-radius: 6px; -fx-min-width: 180px;", normalColor);

        String hoverStyle = String.format("-fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10px 20px; " +
                "-fx-background-color: %s; -fx-text-fill: white; -fx-background-radius: 6px; -fx-min-width: 180px; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 5, 0, 0, 2);", hoverColor);

        button.setStyle(normalStyle);
        button.setOnMouseEntered(e -> button.setStyle(hoverStyle));
        button.setOnMouseExited(e -> button.setStyle(normalStyle));
    }
}