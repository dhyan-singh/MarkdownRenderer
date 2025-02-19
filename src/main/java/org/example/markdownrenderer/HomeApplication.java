package org.example.markdownrenderer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class HomeApplication extends Application {

    private String readAFile() {
        try (BufferedReader r = Files.newBufferedReader(Path.of("./resources/test.md"))) {
            return r.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            return "ERROR OCCURRED";
        }
    }

    private Parent createContent() {
        return new StackPane(new Text(readAFile()));
    }



    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 100, 200);
        stage.setTitle("Markdown Renderer");
        stage.setScene(new Scene(createContent(), 500, 500));
//        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}