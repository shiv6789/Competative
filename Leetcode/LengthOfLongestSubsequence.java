import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LengthOfLongestSubsequence {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(in.nextInt());
        System.out.println(longestSubsequenceLength(list));
    }
    public  static int longestSubsequenceLength(final List<Integer> A) {
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

        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(A.get(i)>A.get(j))
                    dec[i]=Math.max(dec[i],dec[j]+1);
            }
        }
        for(int i=0;i<n;i++)
            System.out.print(inc[i]+" ");

        for(int i=0;i<n;i++)
            System.out.print(dec[i]+" ");

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,inc[i]+dec[i]-1);


        return ans;
    }
}
