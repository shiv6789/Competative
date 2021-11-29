import java.util.HashSet;

public class SmallestMultiplewitj0and1 {
    static boolean check=false;
    static String ans="";
    public String multiple(int A) {
        HashSet<Integer> set=new HashSet<>();
      dfs("1",A);
      return ans;
    }
    public void dfs(String s,int A){
        int rem=mod(s,A);
        if(rem==0){
            check=true;
            ans=s;
        }

        if(!check)
        dfs(s+"0",A);
        if(!check)
        dfs(s+"1",A);

    }
    public static int mod(String t, int N)
{
    int r = 0;
    for(int i = 0; i < t.length(); i++)
    {
        r = r * 10 + (t.charAt(i) - '0');
        r %= N;
    }
    return r;
}
    
}
