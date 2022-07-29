import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
public class startsWithG {
    public static void main(String[] args)
    {

        List<String> l = new ArrayList<>(
                Arrays.asList("hello","Goat"));

        // Creating predicate
        Predicate<String> starts = i -> (i.startsWith("G"));

        // Calling Predicate method
        List<String> res=new ArrayList<>();

        for(String item: l){
            if(starts.test(item)){
                res.add(item);
            }
        }
        System.out.println(res);
    }
}