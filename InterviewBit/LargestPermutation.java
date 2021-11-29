import java.util.ArrayList;
import java.util.Collections;

public class LargestPermutation {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(A.get(i), i);
        }

        if (B >= n) {
            Collections.sort(A, Collections.reverseOrder());
        } else {
            for (int i = n; i >= 1; i--) {
                if (B > 0) {
                    int index = map.get(i);
                    int index1 = n - i;
                    if (index != index1) {
                        map.put(i, index1);
                        int ele = A.get(index1);
                        map.put(ele, index);
                        A.set(index1, ele);
                        A.set(index, A.get(index1));
                        B--;
                    }
                }
            }
        }
        return A;
    }
}
