import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
         set.add(nums[i]);
        }
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:set){
            pq.add(i);
        }
        if(nums.length==0)
            return 0;
            else{
        int ans=Integer.MIN_VALUE;
        int max=1;
        int temp=pq.poll();
        while(!pq.isEmpty()){
            int temp1=pq.poll();
            if(temp1==temp+1){
                max++;
                temp=temp1;
            }
            else{
                ans=Math.max(ans,max);
                temp=temp1;
                max=1;
            }
        }
        ans=Math.max(ans,max);
        return ans;
            }

    }
}