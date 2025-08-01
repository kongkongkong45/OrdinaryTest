package String;
import java.util.Scanner;
public class StringTest {
    public static void main(String[] args) {
        //罗马数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要转换的数字：");
        String str = "";
        boolean flag = false;
        while (!flag) {
            str = sc.next();
            if (str.length() > 9) {
                System.out.println("字符串不符合范围，请重新输入！");
                continue;
            }
            flag= true; // 假设输入有效
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    System.out.println("含有非数字字符，请输入正确的字符串！");
                    flag = false;
                    break;
                }
            }
        }
        String reasult="";
       StringBuilder builder=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count=str.charAt(i)-'0';
            reasult=reasult+new StringBuilder().append(test2(count)).toString();
        }
        System.out.println(reasult);
    }

    public static String test(int i) {
        String arr[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return arr[i];
    }
    public static String test2(int i){
        String s="";
        switch (i){
            case 0:s="";break;
            case 1:s="I";break;
            case 2:s="II";break;
            case 3:s="III";break;
            case 4:s="IV";break;
            case 5:s="V";break;
            case 6:s="VI";break;
            case 7:s="VII";break;
            case 8:s="VIII";break;
            case 9:s="IX";break;

        }
        return s;
    }

    public static class Stringtext2 {
        public static void main(String[] args) {

        }
    }
}

