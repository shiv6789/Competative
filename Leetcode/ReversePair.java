import java.util.Arrays;

public class ReversePair {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int arr[],int left,int right){
        int mid=(left+right)/2;
        //stop merge sort recursion function
        if(left>=right)
            return 0;

        int res=mergeSort(arr,left,mid)+mergeSort(arr,mid+1,right);

        int temp[]=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j])
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=right)
            temp[k++]=arr[j++];


        for (i = left, j = mid+1; i <= mid; i++) {
            while (j <= right && arr[i] / 2.0 > arr[j]) j++;
            res += j - mid - 1;
        }

        for(i=left,k=0;i<=right;i++,k++){
            arr[i]=temp[k];
        }
        return res;
    }
}
