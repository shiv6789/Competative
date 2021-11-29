public class RatWithMazeProblem {
    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};
    static char path[]={'U','R','D','L'};
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list=new ArrayList<>();
        boolean visited[][]=new boolean[n][n];
        visited[0][0]=true;
        if(m[0][0]==1)
        dfs(0,0,m,n,list,"",visited);
        
        if(list.size()==0)
        list.add("-1");
        
        Collections.sort(list);
        return list;
    }
    public static void dfs(int i,int j,int arr[][],int n,ArrayList<String> list,String str,boolean visited[][]){
        
         
       
        
        if(i==n-1 && j==n-1){
        list.add(str);
        return;
        }
        for(int k=0;k<4;k++){
          if(i+dx[k]>=0 && i+dx[k]<n && j+dy[k]>=0 && j+dy[k]<n && !visited[i+dx[k]][j+dy[k]] && arr[i+dx[k]][j+dy[k]]==1){
            visited[i+dx[k]][j+dy[k]]=true; 
            dfs(i+dx[k],j+dy[k],arr,n,list,str+path[k],visited);
            visited[i+dx[k]][j+dy[k]]=false;
          }
        }
    }
}
