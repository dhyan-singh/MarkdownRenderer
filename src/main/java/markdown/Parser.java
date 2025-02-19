package markdown;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import java.util.*;

public class Parser {
    final public String filePath;
    final private List<String> lines;
    private List<MarkdownElement> elements = new ArrayList<>();
    /**
     * @param filePath markdown file location
     */
    public Parser(String filePath) throws IOException {
        this.filePath = filePath;
        // TODO: Check all these things that file exist or not and proper error handling

        try (BufferedReader r = Files.newBufferedReader(Path.of(filePath))) {
            lines = r.lines().toList();
        }
    }

    public List<MarkdownElement> parse() {
        for (var line : lines) {
            switch (line.split(" ")[0]) {
                case "#" -> elements.add(new MarkdownElement(MarkdownElementFormat.HEADER1, line.substring(2)));
            }
        }
        return elements;
    }
}
