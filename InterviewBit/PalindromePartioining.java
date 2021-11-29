import java.util.Stack;

public class PalindromePartioining {
    public ArrayList<ArrayList<String>> partition(String a) {
         
	}
    public static void helper(String s,int i,ArrayList<ArrayList<String>> res,ArrayList<String> list){
        if(i==s.length())
        res.add(new ArrayList<>(temp));

        for(int k=i;k<s.length();k++){
            if(!isPalindrome(s, i,k))
            continue;
            list.ad;
            helper(s,k+1,res,temp);
        }



    }
    public static boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
