package eight;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhangshaolin on 2017/11/23.
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List names= Arrays.asList("1","4","2") ;
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        System.out.println(names);




    }



}
