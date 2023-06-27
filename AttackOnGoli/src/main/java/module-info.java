module com.example.attackongoli {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.attackongoli to javafx.fxml;
    exports com.example.attackongoli;
}