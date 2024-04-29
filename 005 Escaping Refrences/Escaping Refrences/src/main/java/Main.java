
public class Main {
    public static void main(String[] args) {
        Point point = new Point(10, 20);
        long sum = sumOfPoints(point);
        System.out.println("point = " + point   );

    }

    private static long sumOfPoints(Point point) {
        long sumLen = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sumLen += point.toString().length();
        }
        return sumLen;
    }
}
