import java.util.function.Predicate;
public class evenOrNot {
    public static void main(String[] args)
    {
        // Creating predicate
        Predicate<Integer> even = i -> (i%2==0);

        // Calling Predicate method
        System.out.println(even.test(10));
    }
}