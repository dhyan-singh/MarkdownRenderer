package org.example.markdownrenderer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

    public static Text TokenToText(MarkdownElement e) {
        Text t = new Text(e.content());
        switch (e.format()) {
            case HEADER1 -> t.setFont(Font.font("Arial", FontWeight.BOLD, 36));
            case HEADER2 -> t.setFont(Font.font("Arial", FontWeight.BOLD, 32));
            case HEADER3 -> t.setFont(Font.font("Arial", FontWeight.BOLD, 28));

            default -> t.setFont(Font.font("Arial"));
        }
        return t;
    }


    private Parent createContent() {
        var v = new VBox();
        var t = new Text("ONE LINE");
        t.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        try {
            Parser p = new Parser("./resources/test.md");
            List<MarkdownElement> elements = p.parse();
            elements.stream()
                    .map(HomeApplication::TokenToText)
                    .forEach(v.getChildren()::add);
        } catch (IOException e) {
            System.out.println("ERROR OCCURRED HERE");
        }
        v.getChildren().add(t);
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