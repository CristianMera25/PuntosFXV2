module com.mycompany.puntosfxv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.puntosfxv2 to javafx.fxml;
    exports com.mycompany.puntosfxv2;
}
