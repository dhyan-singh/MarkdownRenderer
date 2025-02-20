package org.example.markdownrenderer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Camera;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import markdown.ElementToFX;
import markdown.MarkdownElement;
import markdown.MarkdownElementFormat;
import markdown.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class HomeApplication extends Application {


    private Parent createContent() {
        var v = new VBox();
        v.setPadding(new Insets(12));
        v.setSpacing(1);
        try {
            Parser p = new Parser("./resources/test.md");
            List<MarkdownElement> elements = p.parse();
            elements.stream()
                    .map(ElementToFX::TokenToText)
                    .forEach(v.getChildren()::add);
        } catch (IOException e) {
            System.out.println("ERROR OCCURRED HERE");
        }
        return v;
    }



    @Override
    public void start(Stage stage) {
//        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 100, 200);
//        stage.setScene(scene);
        stage.setTitle("Markdown Renderer");
        stage.setScene(new Scene(createContent(), 500, 500));


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}