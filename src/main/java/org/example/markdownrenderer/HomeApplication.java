package org.example.markdownrenderer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import markdown.Renderer;
import markdown.MarkdownElement;
import markdown.Parser;

import java.io.IOException;
import java.util.List;

public class HomeApplication extends Application {


    private Parent createContent() {
        var v = new VBox();
        v.setPadding(new Insets(12));
        v.setSpacing(1);
        try {
            Parser p = new Parser("./resources/test.md");
            List<MarkdownElement> elements = p.parse();
            elements.stream()
                    .map(Renderer::TokenToText)
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