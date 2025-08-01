package String;
import java.util.Scanner;
public class ee {
    public static void main(String[] args) {
        //创建收据
        //首先接受数据
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要存入的金额：");
        int money;
        //判断金额范围是否正确
        while(true){
            money=sc.nextInt();
            if(money>0&&money<=9999999){
                break;
            }
            else{
                System.out.println("金额错误，请重新输入。");
            }
        }
      //把数字拆分，换成汉字
        String arr= "";
        while(true){
            int ge=money%10;
            arr=character(ge)+arr;
            money=money/10;
            if(money==0){
                break;
            }
            }
        //剩余的未使用数位全部添加为零
        int count=7-arr.length();
        for(int i=0;i<count;i++){
            arr="零"+arr;
        }

      //添加单位
        String Money="";
        for(int j=0;j<arr.length();j++){
            Money=Money+arr.charAt(j);
            Money=Money +Unit(j);

        }
        //检查数据是否有误
        System.out.println(Money);
        }

    //定义一个方法将数字转为文字
    public static String  character(int i){
        String[] str1={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

        return (str1[i]);
    }
    public static  String Unit(int i)
    {
        String[] str2={"佰","仟","万","仟","佰","拾","元"};
        return (str2[i]);
    }

    }

