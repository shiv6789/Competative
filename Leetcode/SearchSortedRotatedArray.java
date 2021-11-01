import java.util.Scanner;

public class SearchSortedRotatedArray {
    public static int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int ind=0;
        while(l<=r){
          int mid=(l+r)/2;
          if(nums[mid]>nums[l]){
              if(mid==nums.length-1){
                  ind=0;
                  break;
              }
              if(nums[mid+1]>nums[mid]){
                  l=mid+1;
              }
              else{
                  ind=mid+1;
                  break;
              }
          }
          else{
             if(mid==0){
                 ind=0;
                 break;
             }
             else
                 r=mid-1;
          }
        }

        System.out.println(ind);

        if(ind==0){
           return binarySearch(nums,target,0,nums.length-1);
        }
        else{
            int one=binarySearch(nums,target,0,ind-1);
            int two=binarySearch(nums,target,ind,nums.length-1);
            if(one!=-1)
                return one;
            else if(two!=-1)
                return two;
            else
                return -1;
        }
    }
    public static int binarySearch(int arr[],int target,int left,int right){
        int ans=-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]<target){
                left=mid+1;

            }
            else if(arr[mid]<target)
                right=mid-1;
            else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
            arr[i]=in.nextInt();

        int target=in.nextInt();
        System.out.println(search(arr,target));
    }
}
