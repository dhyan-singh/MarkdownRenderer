module org.example.markdownrenderer {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.markdownrenderer to javafx.fxml;
    exports org.example.markdownrenderer;
}