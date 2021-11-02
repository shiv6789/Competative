import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestSequenceWithGivenPrimes {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(A);
        pq.add(B);
        pq.add(C);
        ArrayList<Integer> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<Integer>();
        int i=0;
        while(i<D){
           int min=pq.poll();
           if(set.add(min)) {
               i++;
               ans.add(min);
               pq.add(min * A);
               pq.add(min * B);
               pq.add(min * C);
           }
        }
        return ans;
    }
}
