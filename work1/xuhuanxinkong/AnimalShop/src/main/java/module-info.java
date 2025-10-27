module com.example.animalshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animalshop to javafx.fxml;
    exports com.example.animalshop;
}