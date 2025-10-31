package com.example.animalshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class BuyController {


    @FXML
    private Button backBtn;
    @FXML
    private Button buyCatBtn;
    @FXML
    private Button buyDogBtn;
    @FXML
    private VBox functionsBox;
    @FXML
    private VBox buyActionContainer;
    @FXML
    private TextArea outputArea;

    private Main1 main1;

    MyAnimalShop petShop;


    public void setMain1(Main1 main1) {
        this.main1 = main1;
        this.petShop = main1.getPetShop();
    }

    @FXML
    private void onBuyDogClick(ActionEvent actionEvent) {
        // 1. 输入狗狗名称
        TextInputDialog nameDialog = new TextInputDialog();
        nameDialog.setTitle("买入狗狗");
        nameDialog.setHeaderText("请输入狗狗信息");
        nameDialog.setContentText("狗狗名称:");
        Optional<String> nameResult = nameDialog.showAndWait();

        if (!nameResult.isPresent() || nameResult.get().isEmpty()) {
            return; // 用户取消输入
        }
        String name = nameResult.get();

        // 2. 输入狗狗年龄
        TextInputDialog ageDialog = new TextInputDialog("2");
        ageDialog.setTitle("买入狗狗");
        ageDialog.setHeaderText("请输入狗狗年龄");
        ageDialog.setContentText("年龄:");
        Optional<String> ageResult = ageDialog.showAndWait();

        if (!ageResult.isPresent() || ageResult.get().isEmpty()) {
            return;
        }
        int age;
        try {
            age = Integer.parseInt(ageResult.get());
        } catch (NumberFormatException e) {
            outputArea.setText("❌ 请输入有效的年龄数字");
            return;
        }

        // 3. 输入狗狗性别
        ChoiceDialog<String> genderDialog = new ChoiceDialog<>("公", "公", "母");
        genderDialog.setTitle("买入狗狗");
        genderDialog.setHeaderText("请选择狗狗性别");
        genderDialog.setContentText("性别:");
        Optional<String> genderResult = genderDialog.showAndWait();

        if (!genderResult.isPresent()) {
            return;
        }
        String gender = genderResult.get();

        // 4. 输入是否接种疫苗
        ChoiceDialog<Boolean> vaccineDialog = new ChoiceDialog<>(true, true, false);
        vaccineDialog.setTitle("买入狗狗");
        vaccineDialog.setHeaderText("请选择是否接种疫苗");
        vaccineDialog.setContentText("接种疫苗:");
        Optional<Boolean> vaccineResult = vaccineDialog.showAndWait();

        if (!vaccineResult.isPresent()) {
            return;
        }
        boolean isVaccinated = vaccineResult.get();

        // 5. 创建狗狗对象并买入
        StringBuilder sb = new StringBuilder();
        try {
            // 使用用户输入的信息创建 ChineseRuralDog 对象
            Animal dog = new ChineseRuralDog(name, age, gender, isVaccinated);

            // 调用买入方法
            petShop.purchaseAnimal(dog);

            sb.append("✅ 成功买入狗狗!\n");
            sb.append("名称: ").append(name).append("\n");
            sb.append("年龄: ").append(age).append("岁\n");
            sb.append("性别: ").append(gender).append("\n");
            sb.append("接种疫苗: ").append(isVaccinated ? "是" : "否").append("\n");
            sb.append("当前余额: ").append(petShop.getBalance()).append("元");

        } catch (InsufficientBalanceException e) {
            sb.append("❌ 买入失败: ").append(e.getMessage()).append("\n");
        }

        outputArea.setText(sb.toString());
    }


    @FXML
    public void onBuyCatClick(ActionEvent actionEvent) {
        StringBuilder sb = new StringBuilder();

        try {
            // 1. 输入猫咪名称
            TextInputDialog nameDialog = new TextInputDialog();
            nameDialog.setTitle("买入猫咪");
            nameDialog.setHeaderText("请输入猫咪信息");
            nameDialog.setContentText("猫咪名称:");
            Optional<String> nameResult = nameDialog.showAndWait();

            if (!nameResult.isPresent() || nameResult.get().isEmpty()) {
                return; // 用户取消输入
            }
            String name = nameResult.get();

            // 2. 输入猫咪年龄
            TextInputDialog ageDialog = new TextInputDialog("1");
            ageDialog.setTitle("买入猫咪");
            ageDialog.setHeaderText("请输入猫咪年龄");
            ageDialog.setContentText("年龄:");
            Optional<String> ageResult = ageDialog.showAndWait();

            if (!ageResult.isPresent() || ageResult.get().isEmpty()) {
                return;
            }
            int age;
            try {
                age = Integer.parseInt(ageResult.get());
            } catch (NumberFormatException e) {
                outputArea.setText("❌ 请输入有效的年龄数字");
                return;
            }

            // 3. 输入猫咪性别
            ChoiceDialog<String> genderDialog = new ChoiceDialog<>("母", "公", "母");
            genderDialog.setTitle("买入猫咪");
            genderDialog.setHeaderText("请选择猫咪性别");
            genderDialog.setContentText("性别:");
            Optional<String> genderResult = genderDialog.showAndWait();

            if (!genderResult.isPresent()) {
                return;
            }
            String gender = genderResult.get();

            // 4. 输入猫咪颜色
            ChoiceDialog<String> colorDialog = new ChoiceDialog<>("白色", "白色", "黑色", "橘色", "灰色", "三花");
            colorDialog.setTitle("买入猫咪");
            colorDialog.setHeaderText("请选择猫咪颜色");
            colorDialog.setContentText("颜色:");
            Optional<String> colorResult = colorDialog.showAndWait();

            if (!colorResult.isPresent()) {
                return;
            }
            String color = colorResult.get();

            // 5. 创建猫咪对象并买入
            Animal cat = new Cat(name, age, gender, color);
            petShop.purchaseAnimal(cat);

            sb.append("✅ 成功买入猫咪!\n");
            sb.append("名称: ").append(name).append("\n");
            sb.append("年龄: ").append(age).append("岁\n");
            sb.append("性别: ").append(gender).append("\n");
            sb.append("颜色: ").append(color).append("\n");
            sb.append("当前余额: ").append(petShop.getBalance()).append("元\n");
            sb.append("动物数量: ").append(petShop.getAnimalList().size()).append("只");

        } catch (InsufficientBalanceException e) {
            sb.append("❌ 买入失败: ").append(e.getMessage()).append("\n");
        } catch (Exception e) {
            sb.append("❌ 错误: ").append(e.getMessage()).append("\n");
        }

        outputArea.setText(sb.toString());
    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        main1.switchToMain();

    }

    public void onIsClick(ActionEvent actionEvent) {
    }

    public void onNoClick(ActionEvent actionEvent) {
    }
}



