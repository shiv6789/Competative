import java.util.Scanner;

public class Pow {
    static double poww(double x,int n)
    {
        double ans=1;
        while(n>0)
        {
            if((n & 1)==1){
                ans*=x;
            }
            n=n/2;
            x*=x;
        }
        return ans;
    }
    static double myPow(double x, int n) {
        if(n<0){
            return 1/poww(x,n);
        }
        return poww(x,n);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double x=in.nextDouble();
        int n=in.nextInt();
        System.out.println(myPow(x,n));
    }
}
