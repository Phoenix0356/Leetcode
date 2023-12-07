package medium;

public class minReorder {
    int sum;
    public int minReorder(int n, int[][] connections) {
        dfs(connections,0);
        return sum;
    }
    void dfs(int[][] connections,int from){
        for (int i=0;i<connections.length;i++){
            if (connections[i][0]==from) dfs(connections,connections[i][1]);
            if (connections[i][1]==from){
                sum++;
                int temp=connections[i][1];
                connections[i][1]=connections[i][0];
                connections[i][0]=temp;
                dfs(connections,connections[i][0]);
            }
        }
    }

}
