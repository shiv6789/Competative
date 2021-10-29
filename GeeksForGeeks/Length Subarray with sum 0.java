class GfG
{
    int maxLen(int arr[], int n)
    {
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                max=Math.max(max,i-map.get(arr[i]));
            }
            else{
                map.put(arr[i],i);
            }
            
        }
        if(max==Integer.MIN_VALUE)
        return 0;
        else
        return max;
    }
}