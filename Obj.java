import java.util.Scanner;

class Numbers{
    private int a;
    private int b;

    public void sum(){
        System.out.println(a+b);
    }
    public void sub(){
        System.out.println(a-b);
    }

    public void setNum(int a1,int b1){
        a = a1;b=b1;
    }

}
public class Obj {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int a1 = scn.nextInt();
        int b1 = scn.nextInt();

        Numbers Num = new Numbers();
        Num.setNum(a1, b1);

        Num.sum();
        Num.sub();
        scn.close();
    }
}