import java.util.ArrayList;

public class JumpGameArray {
    public int canJump(ArrayList<Integer> A) {
        int n=A.size();
        boolean check[]=new boolean[n];
        int last=n-1;
        for(int i=last-1;i>=0;i--){
            if(A.get(i)+i>=last)
                last=i;

        }

        return (last<=0)?1:0;
    }
}
