import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DisjointIntervals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<Integer>(2));

    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(new Pair(A.get(i).get(0), A.get(i).get(1)));

        Collections.sort(list);

        int length = 1;
        int right = A.get(0).get(1);
        for (int i = 1; i < list.size(); i++) {
            int left = A.get(i).get(0);
            int right1 = A.get(i).get(1);

            if (left > right) {
                length++;
                right = right1;
            }
        }
        return length;
    }
}

class Pair implements Comparable<Pair> {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(Pair p) {
        if (this.second > p.second)
            return 1;
        else if (this.second == p.second)
            return 0;

        return -1;
    }
}
