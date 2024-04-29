import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        Path file = FileSystems.getDefault().getPath( "src/main/java/file_to_read.txt");
        List<String> lines = Files.readAllLines(file);
        lines.forEach(System.out::println);
    }
}
