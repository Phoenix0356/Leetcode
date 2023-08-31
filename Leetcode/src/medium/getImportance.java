package medium;

import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class getImportance {

    public int getImportance(List<Employee> employees, int id) {
        int sum=0;
        Employee next = new Employee();
        for (Employee e : employees) {
            if (e.id == id) {
                next = e;
                break;
            }
        }

        if (next.subordinates==null) return sum;
        sum += next.id;
        for (int n : next.subordinates) {
            sum+=getImportance(employees, n);
        }

        return sum;
    }
}
