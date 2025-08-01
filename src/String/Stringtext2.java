package String;  // 包名小写

import java.util.ArrayList;
import java.util.Arrays;  // 需要这个类来复制数组
import java.util.Scanner;

public class Stringtext2 {
    public static void main(String[] args) {
        Stringtest3 s1 = new Stringtest3("张三",20,20000.0);
        Stringtest3 s2 = new Stringtest3("李四",21,20001.0);
        Stringtest3 s3 = new Stringtest3("王五",22,20002.0);
        ArrayList<Stringtest3> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        //接受索引
        int index=index(list);
        System.out.println(index);

    }
    public static Boolean contain(ArrayList<Stringtest3> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
    public static int index(ArrayList<Stringtest3> List){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查询的姓名：");
        String str=sc.next();
        int index=-1;
        boolean flag=contain(List,str);
        if(flag){
            for (int i = 0; i < List.size(); i++) {
                if (List.get(i).getName().equals(str)) {
                    index=i;
                    return index;
                }

                }
        }
        return index;
    }
}