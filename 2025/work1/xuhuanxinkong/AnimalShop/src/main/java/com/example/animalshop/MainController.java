package com.example.animalshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public VBox buyContainer;
    @FXML
    private VBox mainContainer;

    @FXML
    private Button enterBtn;

    @FXML
    private Button openBtn;

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



    private Main1 main1;


    public void setMain1(Main1 main1) {
        this.main1 = main1;
        refreshDisplay();
        updateOutputArea();
    }

    public void refreshDisplay() {
        if (main1 != null && main1.getPetShop() != null) {
            MyAnimalShop petShop = main1.getPetShop();
            outputArea.setText("🐾 宠物店实时状态\n\n" +
                    "目前资金: " + petShop.getBalance() + "元\n" +
                    "动物数量: " + petShop.getAnimalList().size() + "只\n" );

        }
    }


    private void updateOutputArea() {
        MyAnimalShop petShop = main1.getPetShop();
        outputArea.setText("🐾 欢迎使用宠物店管理系统！\n目前资金:"+petShop.getBalance()+"元\n请点击上方按钮开始操作...:");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void onEnterButtonClick() {
        boolean isVisible = functionsBox.isVisible();
        functionsBox.setVisible(!isVisible);
        openBtn.setVisible(isVisible);
        enterBtn.setText(isVisible ? "进入宠物店管理系统" : "收起功能区");
    }

    public void onEntClick(){
        onEnterButtonClick();
    }


    @FXML
    private void onBuyAnimalClick() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 买入动物 ===\n");
        main1.switchToBuy();
    }

    @FXML
    private void onServeCustomerClick() {
        if (main1 == null || main1.getPetShop() == null) {
            outputArea.setText("网络连接失败");
            return;
        }

        MyAnimalShop petShop = main1.getPetShop();

        // 1. 检查是否有动物可售
        if (petShop.getAnimalList().isEmpty()) {
            outputArea.setText("店内没有动物可出售！\n💡 请先买入动物再招待客户");
            return;
        }
        // 2. 输入客户信息
        TextInputDialog nameDialog = new TextInputDialog();
        nameDialog.setTitle("招待客户");
        nameDialog.setHeaderText("请输入客户信息");
        nameDialog.setContentText("客户姓名:");
        Optional<String> nameResult = nameDialog.showAndWait();

        if (!nameResult.isPresent() || nameResult.get().isEmpty()) {
            return;
        }
        String customerName = nameResult.get();
        // 3. 选择要购买的动物
        List<Animal> animals = petShop.getAnimalList();
        List<String> animalChoices = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            animalChoices.add((i + 1) + ". " + animal.toString());
        }

        ChoiceDialog<String> animalDialog = new ChoiceDialog<>(animalChoices.get(0), animalChoices);
        animalDialog.setTitle("选择动物");
        animalDialog.setHeaderText("请选择客户要购买的动物");
        animalDialog.setContentText("动物:");
        Optional<String> animalResult = animalDialog.showAndWait();

        if (!animalResult.isPresent()) {
            return;
        }
        // 4. 解析选择的动物
        String selectedAnimal = animalResult.get();
        int animalIndex = Integer.parseInt(selectedAnimal.split("\\.")[0]) - 1;

        StringBuilder sb = new StringBuilder();
        sb.append("=== 招待客户 ===\n");

        try {
            Customer customer = new Customer(customerName);
            Animal selectedAnimalObj = animals.get(animalIndex);

            sb.append("客户: ").append(customerName).append("\n");
            sb.append("购买动物: ").append(selectedAnimalObj.toString()).append("\n");
            sb.append("价格: ").append(selectedAnimalObj.getPrice()).append("元\n");
            sb.append("══════════════════\n");

            // 招待客户（卖出选中的动物）
            petShop.serveCustomer(customer);

            sb.append("交易成功!\n");
            sb.append("当前余额: ").append(petShop.getBalance()).append("元\n");
            sb.append("剩余动物: ").append(petShop.getAnimalList().size()).append("只\n");
            sb.append("客户总数: ").append(petShop.getCustomerList().size()).append("位");

        } catch (AnimalNotFoundException e) {
            sb.append("招待失败: ").append(e.getMessage()).append("\n");
        } catch (Exception e) {
            sb.append("错误: ").append(e.getMessage()).append("\n");
        }

        outputArea.setText(sb.toString());
    }

    @FXML
    private void onViewAnimalsClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 店内动物列表 ===\n");
        MyAnimalShop petShop = main1.getPetShop();
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
        MyAnimalShop petShop = main1.getPetShop();
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
        MyAnimalShop petShop = main1.getPetShop();
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
        MyAnimalShop petShop = main1.getPetShop();
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
    @FXML
    private void onOpenBusinessClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 开业 ===\n");
        MyAnimalShop petShop = main1.getPetShop();
        try {
            petShop.openBusiness();
            sb.append("✅ 开业成功！\n");
            sb.append("当前余额: ").append(petShop.getBalance()).append("元\n");

        } catch (Exception e) {
            sb.append("❌ 开业失败: ").append(e.getMessage()).append("\n");
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