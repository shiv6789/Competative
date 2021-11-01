import java.util.Scanner;

public class CountAndSay {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(countAndSay(n));

    }
    public static  String countAndSay(int n) {
        String arr[]=new String[31];
        arr[1]="1";
        for(int i=2;i<=30;i++){
            String s=arr[i-1];
            char ch=s.charAt(0);
            int count=1;
            String res="";
            for(int j=1;j<s.length();j++){
                if(ch==s.charAt(j)){
                    count++;
                }
                else{
                    res+=String.valueOf(count);
                    res+=ch;
                    count=1;
                    ch=s.charAt(j);
                }

            }
            res+=String.valueOf(count);
            res+=ch;
            arr[i]=res;
        }
        return arr[n];
    }

}
