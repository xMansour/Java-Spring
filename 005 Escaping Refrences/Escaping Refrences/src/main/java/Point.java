public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder()
                .append("(")
                .append(x)
                .append(", ")
                .append(y)
                .append(")");
        return stringBuilder.toString();
    }
}
