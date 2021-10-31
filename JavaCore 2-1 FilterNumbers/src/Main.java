import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbersList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        Stream<Integer> numberStream = numbersList.stream();
        numberStream
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted()
                .forEach(x -> System.out.print(x + " "));
    }
}
