import java.util.Scanner;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
         Scanner in=new Scanner(System.in);
         int n=in.nextInt();
         int arr[]=new int[n];
         for(int i=0;i<n;i++)
             arr[i]=in.nextInt();

         System.out.println(trap(arr));
    }
    public  static int trap(int[] arr) {
        Stack<Integer> s=new Stack<>();

        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++) {
            while (!s.isEmpty() && arr[s.peek()]<arr[i]) {
                int last=arr[s.peek()];
                s.pop();

                if(s.isEmpty())
                    break;

                int width=i-s.peek()-1;

                int height=Math.min(arr[i],arr[s.peek()])-last;
                sum+=width*height;
            }
            s.add(i);
        }
        return sum;
    }

}
