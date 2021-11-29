public class PainterParitionProblem {
    public int paint(int A, int B, int[] C) {
        
        int n=C.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            max=Math.max(C[i],max);
            sum+=C[i];

        }

        int low=max;
        int high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int req=helper(C,mid);
            if(req>A){
               low=mid+1;
            }
            else{
               high=mid-1; 
            }
        }
        return high;
        
    }
    public static int helper(int arr[],int max){
        int sum=0;
        int painter=1;
        for(int i=0;i<arr.length;i++){
               sum+=arr[i];
               if(sum>max){
                   sum=arr[i];
                   painter++;
               }
        }
        return painter;
    }
    
}
