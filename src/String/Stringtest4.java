package String;

import java.util.ArrayList;

public class Stringtest4 {
    public static void main(String[] args) {
        StringPhone sp1 = new StringPhone("小米", 1000);
        StringPhone sp2 = new StringPhone("苹果", 8000);
        StringPhone sp3 = new StringPhone("锤子", 2999);
        ArrayList<StringPhone> list1 = new ArrayList<>();
        ArrayList<StringPhone> list2 = new ArrayList<>();
        list1.add(sp1);
        list1.add(sp2);
        list1.add(sp3);
        list2=Judgment(list1);
        for(int j=0;j<list2.size();j++){
            System.out.println(list2.get(j).getBrand()+" "+list2.get(j).getPrice());
        }

    }
    //返回低于3000的手机信息
    public static ArrayList<StringPhone> Judgment(ArrayList<StringPhone> list) {
        ArrayList<StringPhone> List=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPrice()<3000){
                List.add(list.get(i));
            }
        }
        return List;
    }
}
