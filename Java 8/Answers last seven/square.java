import java.util.function.Function;

public class square {

    public static void main(String[] args) {

        Function<Integer,Integer> func = x -> (x*x);

        Integer apply = func.apply(2);

        System.out.println(apply);

    }

}
