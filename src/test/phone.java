package test;

import java.util.Scanner;

public class phone {
    public static void main(String[] args) {
      //  Scanner input = new Scanner(System.in);
        //第一种展示手机信息
        phoenFeature f1 = new phoenFeature("苹果","粉色",7899.0);
        phoenFeature f2 = new phoenFeature("华为","黑色",5999.0);
        phoenFeature f3 = new phoenFeature("vivo","白色",4999);
        f1.PhoneNew(f1.getBrand(), f1.getColor(), f1.getPrice());
        f2.PhoneNew(f2.getBrand(), f2.getColor(), f2.getPrice());
        f1.PhoneNew(f3.getBrand(), f3.getColor(), f3.getPrice());
        System.out.println("================");
        double average=(f1.getPrice()+ f2.getPrice()+ f3.getPrice())/3;
        System.out.println("这三部手机的平均价格是："+average);
        //第二种创建数组展示信息
        phoenFeature F[]=new phoenFeature[3];
        //输入数组数据
        F[0]=f1;
        F[1]=f2;
        F[2]=f3;

        int  num=0;
        for(int i=0;i<F.length;i++)
        {
            num+=F[i].getPrice();
            System.out.println(F[i].getBrand()+F[i].getColor()+F[i].getPrice());
        }
        System.out.println(num/3);
        int count=0;
        for(int i=0;i<F.length;i++)
        {
            if(num/3>F[i].getPrice())
            {
                count++;
                System.out.println(F[i].getBrand()+F[i].getColor()+F[i].getPrice());
            }
        }
        System.out.println("比平均价格低的有："+count+"个");


    }
}
