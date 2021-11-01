import java.util.*;
import java.util.List;

class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        
        
        Arrays.sort(nums);//sorted array used in two pointers approach
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               int front=j+1;
               int back=n-1;
                int target1=target-nums[i]-nums[j];
                
                //two pointer approach done in o(logn).
               while(front<back){
                   if(target1>nums[front]+nums[back])
                       front++;
                   else if(target1<nums[front]+nums[back])
                       back--;
                   else{
                       ArrayList<Integer> res=new ArrayList<>();
                       res.add(nums[i]);
                       res.add(nums[j]);
                       res.add(nums[front]);
                       res.add(nums[back]);
                       ans.add(res);
                       
                       //eliminating duplicates 3rd elements.
                       while(front< back && nums[front]==res.get(2) )
                           front++;
                       
                           //eliminating duplicates 4th elements.
                       while(front<back && nums[back]==res.get(3))
                           back--;
                   }
                       
               }
               //eliminating duplicates 2nd element.
                while(j + 1 < n && nums[j+1] == nums[j]) ++j;
            }
            //eliminating duplicates 1st element.
            while(i + 1 < n && nums[i+1] == nums[i]) ++i;
        }
        return ans;
    }
}