package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Search_Suggestions_System {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < products.length; i++) {
            set.add(products[i]);
        }

        String[] str = set.toArray(new String[0]);
        List<List<String>> ret = new LinkedList<>();

        for(int i = 0; i < searchWord.length(); i++) {
            String search = searchWord.substring(0, i+1);
            List<String> list = new ArrayList<>();

            for(int j = 0; j < str.length; j++) {
                if(str[j].startsWith(search)) {
                    list.add(str[j]);
                }

                if(list.size() == 3) break;
            }

            ret.add(list);
        }

        return ret;
    }
}
