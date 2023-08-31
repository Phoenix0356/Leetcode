package easy;

import java.util.*;

public class findAllRecipes {
    boolean[] visited;
    boolean[] make;
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        int n = recipes.length;
        visited = new boolean[n];
        make = new boolean[n];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], i);
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(supplies));
        for (int i = 0; i < n; i++) {
            if (!visited[i]) make[i] = canDo(i, ingredients, set, map);
            if (make[i]) res.add(recipes[i]);
        }
        return res;
    }
    public boolean canDo(int index, List<List<String>> ingredients, HashSet<String> set, HashMap<String, Integer> map) {
        if (visited[index]) {
            return make[index];
        } else {
            visited[index] = true;
            for (String item: ingredients.get(index)) {
                if (!set.contains(item) ) {
                    if (!map.containsKey(item)) return false;
                    int i = map.get(item);
                    make[i] = canDo(i,ingredients, set, map);
                    if (!make[i]) {
                        return false;
                    }
                }
            }
            make[index] = true;
            return true;
        }
    }
}
