package markdown;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Arrays;

public class ElementToFX {
    public static Text TokenToText(MarkdownElement e) {
        Text t = new Text(e.content());
        if (e.format() == MarkdownElementFormat.BULLET_POINT) {
            t = new Text("•" + " " + e.content());
        }
        switch (e.format()) {
            case HEADER1 -> t.setFont(Font.font("Arial", FontWeight.BOLD, 36));
            case HEADER2 -> t.setFont(Font.font("Arial", FontWeight.BOLD, 32));
            case HEADER3 -> t.setFont(Font.font("Arial", FontWeight.BOLD, 25));
            default -> t.setFont(Font.font("Arial"));
        }
        return t;
    }
}
