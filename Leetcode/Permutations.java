import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       int n=in.nextInt();
       int arr[]=new int[n];
       for(int i=0;i<n;i++)
           arr[i]=in.nextInt();

       System.out.println(permute(arr));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,ans,0,nums.length-1);
        return ans;
    }
    public static void helper(int arr[],List<List<Integer>> ans,int l,int r){
        //base condition
        if(l==r){
            ArrayList<Integer> res =
                    new ArrayList<Integer>();
            for (int i = 0; i < arr.length; i++)
                res.add(new Integer(arr[i]));
            //adding a list to 2d array list
            ans.add(res);
        }

        for(int i=l;i<=r;i++){
             arr=swap(arr,l,i);//swap first charcaterc of every substring
             helper(arr,ans,l+1,r);//forwading the same to next substring
             arr=swap(arr,l,i);//backtrack to latest position
        }
    }
    //also return an array to have chaanges in array afer swap.
    public static int[] swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}
