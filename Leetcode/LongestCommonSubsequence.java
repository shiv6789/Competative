import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s1=in.next();
        String s2=in.next();
        System.out.println(lcs(s1,s2));
    }
    //bottom up approach using dp
    public static int lcs(String s1,String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][m];
    }
    static int dp[][];
    //recusrion with memozation
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                dp[i][j]=-1;
        }
        return helper(text1,text2,n,m);
    }
    public int helper(String s1,String s2,int n,int m){
        if(n==0||m==0)
            return 0;

        if(dp[n-1][m-1]!=-1)
            return dp[n-1][m-1];

        if(s1.charAt(n-1)==s2.charAt(m-1))
            return dp[n-1][m-1]=1+helper(s1,s2,n-1,m-1);
        else
            return dp[n-1][m-1]=Math.max(helper(s1,s2,n,m-1),helper(s1,s2,n-1,m));
    }
}
