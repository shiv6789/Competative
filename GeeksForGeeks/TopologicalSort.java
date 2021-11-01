import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

    }
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj)
    {


        boolean visited[]=new boolean[n];
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<n;i++){
            if(!visited[i]){
                 dfs(i,adj,s,visited);
            }
        }

        int res[]=new int[n];
        int k=0;
        while(!s.isEmpty()){
            res[k++]=s.pop();
        }
        return res;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack s,boolean visited[]){
        visited[node]=true;
       for(int i:adj.get(node)){
           if(!visited[i]){
               dfs(i,adj,s,visited);
           }
       }
       s.push(node);
    }
}
