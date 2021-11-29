import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(in.nextInt());
        System.out.println(majorityElement(list));
    }

    public static int majorityElement(final List<Integer> A) {
        int n = A.size();
        int count = 0;
        int majority = 0;
        if (n == 1)
            majority = A.get(0);
        else {
            for (int i = 0; i < n; i++) {
                if (count == 0) {
                    majority = A.get(i);
                    count = 1;
                } else if (majority == A.get(i))
                    count++;
                else
                    count--;

            }
        }
        return majority;
    }
}
