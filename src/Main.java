import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String text = "example,nejake,textu,pres,String";

        Scanner sc = new Scanner(text);
        sc.useDelimiter(",");
        while (sc.hasNext()){
            System.out.println(sc.next());
        }

//        for (int a = 5, b = 20;a < 50; Sysem.out.println(a) ){
//            System.out.println(":(");
//        }

    }
}