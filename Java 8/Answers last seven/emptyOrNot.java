package lastseven.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
public class emptyOrNot {
    public static void main(String[] args)
    {

        List<String> l = new ArrayList<>(
                Arrays.asList("hello"));

        // Creating predicate
        Predicate<List> empty = i -> (i.isEmpty());

        // Calling Predicate method
        System.out.println(empty.test(l));
    }
}