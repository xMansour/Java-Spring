import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Cairo");
        cities.add("Dahab");
        cities.add("Sharm");

        //TIP consumer lambda function acts on an object.
        Consumer<String> printItems = System.out::println;
        cities.forEach(printItems);

        //TIP function lambda that takes an input and produces an output.
        Function<Integer, Integer> doubly = n -> n * n;
        System.out.println("Doubly: " + doubly.apply(5));

        //TIP predicate lambda, expression that returns true or false depending on the input
        IntPredicate isDivByThree = n -> n % 3 == 0;
        System.out.println("isDivByThree: " + isDivByThree.test(10));
        System.out.println("isDivByThree: " + isDivByThree.test(9));

        //TIP supplier lambda function takes no input and produces output.
        Supplier<Double> random100 = () -> Math.random() * 100;
        System.out.println(random100.get());

    }
}
