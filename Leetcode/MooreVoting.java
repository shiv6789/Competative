import java.util.Scanner;

public class MooreVoting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int candidate = findMajorityElement(arr);
        System.out.println(check(arr, candidate));
    }

    public static int findMajorityElement(int arr[]) {
        int majority = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == majority)
                count++;
            else
                count--;
            if (count == 0) {
                majority = arr[i];
                count = 1;
            }
        }
        return majority;
    }

    public static boolean check(int arr[], int majority) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == majority)
                count++;
        }
        if (count > arr.length / 2)
            return true;
        else
            return false;
    }
}
