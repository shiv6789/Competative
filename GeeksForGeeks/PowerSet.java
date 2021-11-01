import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PowerSet {
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       String s=in.next();
        List<String> ans=new ArrayList<>();
        ans=AllPossibleStrings(s);

       System.out.print(ans);
    }
    public  static List<String> AllPossibleStrings(String s)
    {
        ArrayList<String> ans=new ArrayList<>();
        char ch[]=s.toCharArray();
          helper(ch,0,ans,"");
        Collections.sort(ans);
          return ans;
    }
    public static  void helper(char ch[], int index, ArrayList<String> ans,String s1){
        if(index>=ch.length) {
            if(!s1.equals(""))
            ans.add(s1);
            return;
        }

        helper(ch,index+1,ans,s1+ch[index]);
        helper(ch,index+1,ans,s1);


    }
}
