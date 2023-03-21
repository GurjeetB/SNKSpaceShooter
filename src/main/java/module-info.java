module ca.bcit.comp2522.termproject.snk {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproject.snk to javafx.fxml;
    exports ca.bcit.comp2522.termproject.snk;
}