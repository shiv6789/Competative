import java.util.ArrayList;
import java.util.List;

public class Inorder {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helper(root,list);
        return list;
    }
    public static void helper(TreeNode root,List<Integer> list){
        if(root.left!=null)
            helper(root.left,list);

        list.add(root.val);

        if(root.right!=null)
            helper(root.right,list);


    }
}
class TreeNode {
       int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
