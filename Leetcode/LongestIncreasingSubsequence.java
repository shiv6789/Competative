import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lis(final List<Integer> A) {
        int n=A.size();
        int inc[]=new int[n];
        int dec[]=new int[n];

        Arrays.fill(inc,1);
        Arrays.fill(dec,1);
        if(n==0)
            return 0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(A.get(i)>A.get(j))
                    inc[i]=Math.max(inc[i],inc[j]+1);
            }
        }


        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,inc[i]);

        return ans;

    }
}
