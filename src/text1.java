
import java.util.Random;
import java.util.Scanner;
public class text1 {
    public static void main(String[] args) {
        //双色球投注
        int arr[]=creatNumber();
        System.out.println("================================ ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");
        int Userarr[]=UserNumber();
        //判断用户中奖情况
        int count=0;
        for(int i=0;i<Userarr.length-1;i++){
            for(int j=i;j<arr.length-1;j++){
                if(Userarr[i]==arr[i]){
                    count++;
                    break;
                }
            }
        }
        int count1=0;
        if(arr[arr.length-1]==Userarr[Userarr.length-1]){
            count1++;
        }
        //判断中奖情况
        if(count==6&&count1==1){
            System.out.print("恭喜你，中奖一千万");
        }
        else if(count==6&&count1==0){
            System.out.print("恭喜你，中奖五百万");
        }
        else if(count==5&&count1==1){
            System.out.print("恭喜你，中奖三千元");
        }
        else if(count==4&&count1==1||count==5&&count1==0){
            System.out.print("恭喜你，中奖两百元");
        }
        else if(count1==0&&count==4||count1==1&&count==3){
            System.out.print("恭喜你，中奖十元");
        }
        else if(count1==0&&count==1||count1==1&&count==1||count1==1&&count==2){
            System.out.print("恭喜你，中奖5元");
        }
        else if(count1==0&&count==0){
            System.out.print("很抱歉您并没有中奖");
        }
    }
    //用户输入红球号码
    public static int [] UserNumber()
    {
        Scanner sc=new Scanner(System.in);
        int[] userarr=new int[7];
        for(int i=0;i<userarr.length-1;) {
            System.out.println("请输入第" + (i + 1) + "个红球号码:");
            int Userrednumber = sc.nextInt();
            if (Userrednumber >= 1 && Userrednumber <= 33) {
                Boolean flag = RedFlag(userarr, Userrednumber);
                if (flag) {
                    userarr[i] = Userrednumber;
                    i++;
                }
                else {
                    System.out.println("号码重复请重新输入");
                }
            }
            else {
                System.out.println("号码无效重新输入");
            }
        }
        //用户输入蓝球号码
        System.out.println("请输入蓝球号码：");
        boolean flag=false;
        while(!flag) {
            int Userbluenumber=sc.nextInt();
            if (Userbluenumber >= 1 && Userbluenumber <= 16) {
                userarr[userarr.length - 1] = Userbluenumber;
                flag=true;
                break;
            } else {
                System.out.print("号码无效请重新输入:");
            }
        }
        return userarr;
    }
    //随机生成中奖号码
    public static int[] creatNumber() {
        int arr[] = new int[7];
        Random rand = new Random();
        for (int i = 0; i < 7; ) {
            //随机数字
            int RedNumber = rand.nextInt(33) + 1;
            //判断红色数字是否重复
            boolean flag = RedFlag(arr,RedNumber);
            if (flag) {
                //将随机数字放入数组中
                arr[i] = RedNumber;
                i++;
            }
        }
        //随机蓝球号码
        Random rand2 = new Random();
        arr[arr.length - 1] = rand2.nextInt(7) + 1;
        return (arr);
    }
    //判断随机红球中是否重复
    private static boolean RedFlag(int[] arr, int RedNumber) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == RedNumber) {
                return false;
            }
        }

        return true;
    }
}