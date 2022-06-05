module ru.gb.smykov.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.smykov.javafxapp to javafx.fxml;
    exports ru.gb.smykov.javafxapp;
}