import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int num = 2;
        System.out.println("num = " + num);
        String season = switch (num) {
            case 0 -> "Spring";
            case 1 -> "Summer";
            case 2 -> "Fall";
            case 3 -> "Winter";
            default -> "";
        };
        System.out.println("season = " + season);

    }
}
