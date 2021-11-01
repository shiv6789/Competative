import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WaterFlow {
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,1,-1};
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>(m);
            for(int j=0;j<m;j++)
                arr.add(in.nextInt());

            ans.add(arr);
        }
        System.out.println(solve(ans));
    }
    public static int solve(ArrayList<ArrayList<Integer>> A) {
            boolean ans[][]=new boolean[A.size()][A.get(0).size()];
            for(int i=0;i<A.get(0).size();i++)
                dfs(0,i,ans,A);

            for(int i=0;i<A.size();i++){
                dfs(i,0,ans,A);
            }

            //print(ans);
            int lastRow=A.size()-1;
            int lastCol=A.get(0).size()-1;

            boolean ans1[][]=new boolean[A.size()][A.get(0).size()];

           for(int i=0;i<A.size();i++)
               dfs(i,lastCol,ans1,A);

           for(int i=0;i<A.get(0).size();i++)
               dfs(lastRow,i,ans1,A);
           //print(ans1);
        boolean ans2[][]=new boolean[A.size()][A.get(0).size()];
           for(int i=0;i<A.size();i++){
               for(int j=0;j<A.get(0).size();j++)
                   ans2[i][j]=ans1[i][j]&ans[i][j];
           }
           //print(ans2);
           int count=0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++)
                if(ans2[i][j])
                    count++;
        }

       return count;
    }
   public static void print(boolean arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
   }
    public static void dfs(int i,int j,boolean ans[][],ArrayList<ArrayList<Integer>> A){
        ans[i][j]=true;
        int par=A.get(i).get(j);
        for(int k=0;k<4;k++){
            if(isSafe(dx[k]+i,j+dx[k],A.size(),A.get(0).size()) && !ans[i+1][j] && A.get(i+dx[k]).get(j+dx[k])>=par)
                dfs(i+dx[k],j+dx[k],ans,A);
        }
//        if(isSafe(i+1,j,A.size(),A.get(0).size()) && !ans[i+1][j] && A.get(i+1).get(j)>=A.get(i).get(j))
//            dfs(i+1,j,ans,A);
//        if(isSafe(i,j+1,A.size(),A.get(0).size()) && !ans[i][j+1] && A.get(i).get(j+1)>=A.get(i).get(j))
//            dfs(i,j+1,ans,A);
//        if(isSafe(i-1,j,A.size(),A.get(0).size()) && !ans[i-1][j] && A.get(i-1).get(j)>=A.get(i).get(j))
//            dfs(i-1,j,ans,A);
//        if(isSafe(i,j-1,A.size(),A.get(0).size()) && !ans[i][j-1] && A.get(i).get(j-1)>=A.get(i).get(j))
//            dfs(i,j-1,ans,A);
    }
    public static boolean isSafe(int i,int j,int m,int n){
        if(i>=0 && j>=0 && i<m && j<n)
            return true;
        return false;
    }
}
