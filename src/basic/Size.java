package basic;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Size {



    public static void main(String[] args) throws IOException {
        final Map<String, Integer> locMap = new HashMap<>(12);
        System.out.println(locMap.size());
        locMap.put("", 1);
        System.out.println(locMap.size());
    }

}
