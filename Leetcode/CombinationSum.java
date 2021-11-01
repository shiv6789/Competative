import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        helper(candidates, target, 0, res, curr);

        return res;
    }

    public void helper(int[] candidates, int target, int index,
                          List<List<Integer>> res, List<Integer> curr)
    {
        if(target < 0)
            return;

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            curr.add(candidates[i]);
            helper(candidates, target-candidates[i], i, res, curr);
            curr.remove(curr.size()-1);
        }
    }
}
