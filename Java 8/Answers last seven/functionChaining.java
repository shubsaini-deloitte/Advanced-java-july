import java.util.function.Function;

public class functionChaining {

    public static void main(String[] args) {

        Function<Integer, Integer> func = x -> x/2;

        Function<Integer, Integer> func2 = x -> x * 3;

        Integer result = func.andThen(func2).apply(10);

        System.out.println(result);

    }

}
