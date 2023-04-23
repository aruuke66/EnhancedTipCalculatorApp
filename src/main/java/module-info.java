module com.example.enhancedtipcalculatorapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.enhancedtipcalculatorapp to javafx.fxml;
    exports com.example.enhancedtipcalculatorapp;
}