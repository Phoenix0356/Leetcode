package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class BrowserHistory {
    Deque<String> s1 = new LinkedList<>();
    Deque<String> s2 = new LinkedList<>();
    public BrowserHistory(String homepage) {
        s1.push(homepage);
    }

    public void visit(String url) {
        s1.push(url);
        s2.clear();
    }

    public String back(int steps) {
        for(int i = 0;i < steps && s1.size() > 1;i++){
            s2.push(s1.pop());
        }
        return s1.peek();
    }

    public String forward(int steps) {
        for(int i = 0;i < steps && !s2.isEmpty();i++){
            s1.push(s2.pop());
        }
        return s1.peek();
    }
}
