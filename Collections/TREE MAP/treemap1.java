
import java.util.*;
public class treemap1 {
    public static void main(String args[]){
        TreeMap<Integer,String> tree_map=new TreeMap<Integer,String>();
        tree_map.put(1, "A");
        tree_map.put(2, "B");
        tree_map.put(3, "C");
        tree_map.put(4, "D");
        tree_map.put(5, "E");

        for (Map.Entry<Integer,String> entry : tree_map.entrySet())
        {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }
    }
}