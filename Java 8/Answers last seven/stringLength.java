import java.util.function.Function;

public class stringLength {

    public static void main(String[] args) {

        Function<String, Integer> func = x -> x.length();

        Integer apply = func.apply("Hello");

        System.out.println(apply);

    }


}
