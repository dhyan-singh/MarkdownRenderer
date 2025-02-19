package org.example.markdownrenderer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        String styles = "-fx-background-color: #0000ff;" +
                "-fx-border-color: #ff0000;" +
                "-font-color: white;" +
                "-color: white;";
        welcomeText.setStyle(styles);
    }
}