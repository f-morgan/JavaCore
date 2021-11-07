import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    //BinaryOperator<Integer> devide = (x, y) -> x / y; Может вызвать ошибку деления на 0
    //BinaryOperator<Integer> devide = (x, y) ->  y == 0 ? null : x / y; Исправление, но без отлавливания ArithmeticException
    BinaryOperator<Integer> devide = (x, y) ->  {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
        return Integer.MAX_VALUE;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}
