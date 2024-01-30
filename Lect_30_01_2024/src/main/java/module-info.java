module com.example.lect_30_01_2024 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lect_30_01_2024 to javafx.fxml;
    exports com.example.lect_30_01_2024;
}