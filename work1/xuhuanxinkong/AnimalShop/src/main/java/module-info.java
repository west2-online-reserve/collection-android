module com.example.animalshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens com.example.animalshop to javafx.fxml;
    exports com.example.animalshop;
}