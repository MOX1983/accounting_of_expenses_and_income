module com.example.finance {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finance to javafx.fxml;
    exports com.example.finance;
}