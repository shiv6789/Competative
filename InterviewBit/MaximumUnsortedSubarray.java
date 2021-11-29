import java.util.ArrayList;
import java.util.Scanner;

public class MaximumUnsortedSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(in.nextInt());
        System.out.println(subUnsort(list));

        in.close();
    }

    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = A.size();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (A.get(left) > A.get(right) || left == right)
                break;

            if (A.get(left) <= A.get(left + 1))
                left++;

            if (A.get(right) >= A.get(right - 1))
                right--;
        }

        if (left == right)
            list.add(-1);
        else {
            list.add(left);
            list.add(right);
        }
        return list;

    }
}
