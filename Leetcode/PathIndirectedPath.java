import java.sql.Array;
import java.util.ArrayList;

public class PathIndirectedPath {
    public static void main(String[] args) {

    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> arr[]=new ArrayList[A+1];
        for(int i=1;i<=A;i++)
            arr[i]=new ArrayList<>();

        int edges=B.size();
        for(int i=0;i<edges;i++){
            int first=B.get(i).get(0);
            int second=B.get(i).get(1);
            arr[first].add(second);
        }
        boolean visited[]=new boolean[A];
        boolean res=dfs(1,visited,arr,A);
        if(res)
            return 1;
        else
            return 0;

    }
    public static boolean dfs(int node,boolean visited[],ArrayList<Integer> arr[],int n){
        if(node==n)
            return true;

        visited[node]=true;
        for(int i:arr[node]){
            if(!visited[i]){
                if(dfs(i,visited,arr,n))
                    return true;
            }
        }
        return  false;
    }
}
