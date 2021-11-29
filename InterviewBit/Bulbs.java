import java.util.ArrayList;

public class Bulbs {
    public static void main(String[] args) {

    }

    public int bulbs(ArrayList<Integer> A) {
        int n = A.size();
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) == 0 && right % 2 == 0 || A.get(i) == 1 && right % 2 == 1) {
                right++;
            }
        }
        return right;
    }
}
