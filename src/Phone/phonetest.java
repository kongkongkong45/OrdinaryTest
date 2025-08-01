package Phone;
import java.util.Scanner;
public class phonetest {
    public static void main(String[] args) {
        //拼接数组
        int[] arr={1,2,3};
        String str=test(arr);
      System.out.println(str);
    }
    //创建一个方法，按照指定格式，拼接一个字符串并返回
    public static String test(int[] arr){
        StringBuilder s=new StringBuilder();
        s.append("[");
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                s.append(arr[i]);
            }
            else{
                s.append(arr[i]+",");
            }
        }
        s.append(123);
        return s.toString();
    }
}
