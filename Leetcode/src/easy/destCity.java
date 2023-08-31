package easy;

import java.util.List;

public class destCity {
    List<List<String>> cities;
    public String destCity(List<List<String>> paths) {
        cities=paths;
        return dfs(paths.get(0).get(1));
    }
    String dfs(String start){
        for (List<String> city:cities){
            if (city.get(0).equals(start)){
                return dfs(city.get(1));
            }
        }
        return start;
    }
}
