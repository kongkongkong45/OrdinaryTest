package Management;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Item {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       System.out.println("----欢迎来到学生管理系统----");
        ArrayList<User> list = new ArrayList<>();
        list=Choose(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getUserName()+list.get(i).getPassWord());
        }

    }
    //选择选项
    public static ArrayList<User>  Choose(ArrayList<User> list) {

        loop:while (true) {
            System.out.println("---请选择操作 1登录 2注册 3忘记密码 4退出---");
            int choose =  sc.nextInt();
            switch (choose) {
                case 1:list=login(list);break;
                case 2:list=register(list);break;
                case 3:list=forgotPassword(list);break;
                case 4:break loop;

                default :System.out.println("指令错误，请重新输入"); break;
            }
        }
      return list;
    }
    //注册功能
    public static ArrayList<User> register(ArrayList<User> list) {
        System.out.println("--请输入要创建的用户名：--");

        User newUser = new User();
        //判断用户名是否符合标准
        while (true) {
            String name = sc.next();
            int  resultCode=checkUserName(name,list);
            if(resultCode==1){
                newUser.setUserName(name);
                System.out.println("--用户名创建成功！--");
                System.out.println(" ");
                break;
            }
            else if(resultCode==-1){
                System.out.println("用户名重复，请重新输入！");
            }
            else if(resultCode==-2) {
                System.out.println("用户名长度不符，请重新输入！");
            }
            else if(resultCode==-3) {
                System.out.println("用户名不能是纯数字或者字符，请重新输入！");
            }

        }
       loop: while (true) {
            int maxAttempts = 2;
            int attempts = 0;

            System.out.println("---请输入注册密码---：");
           String password = sc.next();

            while (attempts < maxAttempts) {

                System.out.println("请再次输入你的密码：");
                String confirmPassword = sc.next();

                if (confirmPassword.equals(password)){
                    System.out.println("---密码创建成功！--");
                    newUser.setPassWord(password);
                    System.out.println(" ");
                    break loop;
                } else {
                    attempts++;
                    if (attempts < maxAttempts) {
                        System.out.println("该密码与上次不同，你还有 " + (maxAttempts - attempts) + " 次机会！");
                    } else {
                        System.out.println("该密码已失效，请重新开始注册流程");

                    }
                }
            }
        }
        //身份证号
        System.out.println("--请输入你的身份证号码：--");
        while(true){
            String Id = sc.next();
            int resultCode=checkId(Id);
            if(resultCode==0){
                newUser.setID(Id);
                System.out.println("--身份证号验证成功！--");
                System.out.println("");
                break;
            }
            else if(resultCode==-1){
                System.out.println("身份证号长度不符合要求，请重新输入！");
            }
            else if(resultCode==-2) {
                System.out.println("身份证号第一位不能为零，请重新输入！");
            }
            else if(resultCode==-3) {
                System.out.println("身份证形式不符合要求，请重新输入！");
            }
        }
        //手机号码验证
        System.out.println("--请输入你的手机号码：--");
        while(true){
            String phone = sc.next();
            int resultCode=checkPhone(phone);
            if(resultCode==0){
                newUser.setPhone(phone);
                System.out.println("--手机号验证成功！--");
                System.out.println("");
                break;
            }
            else if(resultCode==-1){
                System.out.println("手机号长度不符合要求，请重新输入！");
            }
            else if(resultCode==-2) {
                System.out.println("手机号不能以0开头，不符合要求，请重新输入！");
            }
            else if(resultCode==-3) {
                System.out.println("手机号出现非数字内容，请重新输入！");
            }

        }
        System.out.println("恭喜你！注册成功");
        list.add(newUser);
        return list;
    }
    //登录功能
    public static ArrayList<User> login(ArrayList<User> list) {

        //list中没有数据
        if(list.size()==0){
            System.out.println("用户未注册，请先注册！");
            return list ;
        }

            //用户登录用户名

            System.out.println("---请输入要登陆的用户名---");

            String userName = sc.next();


                //未注册用户登录
                User matchedUser = null;
                for (User user : list) {
                    if (user.getUserName().equals(userName)) {
                        matchedUser = user;
                        break;
                    }
                }
                if (matchedUser == null) {
                    System.out.println("用户未注册，请先注册！");
                    return list;  // 不应该返回 null，避免后续空指针

            }

           System.out.println("---请输入密码---");
           String password = sc.next();
           while (true) {
               String verifyCode=verifyCode();
               System.out.println("验证码："+verifyCode);
               System.out.println("---请输入验证码---");
               //验证码是否正确
               String VerifyPassword = sc.next();
               if(!verifyCode.equals(VerifyPassword)){
                   System.out.println("验证码错误，请重新输入！");
               }
               else{
                   break;
               }
           }

            //验证
           int maxAttempts = 3;
           int attempts = 0;
            while(attempts < maxAttempts) {
               int GetNameCount=checkUserLogin(userName,password,list);
                //验证用户名和密码是否正确，只有三次机会
                 if(GetNameCount==-1){
                    attempts++;

                    System.out.println("用户名或者密码错误，你还有"+ (maxAttempts-attempts)+"次机会");

                     System.out.println("---输入要登陆的密码---");
                     password=sc.next();
                    if(attempts>=maxAttempts){
                        System.out.println("密码已失效，请重新输入");

                    }
                }
                else  {
                    System.out.println("恭喜你，登陆成功！");
                    break ;
                }
            }

        return list;
    }
    //忘记密码功能
    public static ArrayList<User>  forgotPassword(ArrayList<User> list) {

        //list中没有数据
        if(list.size()==0){
            System.out.println("用户未注册，请先注册！");
            return  null;
        }
        //先判断用户名是否存在
        System.out.println("---请输入用户名---");

        String userName = sc.next();
        String userPassword=" ";

        //遍历用户名

        int index = -1;
        for (int i=0;i<list.size();i++) {
            if (userName.equals(list.get(i).getUserName())) {  // 如果用户名匹配
                index=i;
                break;//找到后立即退出循环

            }

        }
        if (index == -1) {
            System.out.println("用户未注册，请注册");
            return null;
        }



        System.out.println("---请输入身份证号---");
        String verifyId=sc.next();
        System.out.println("---请输入手机号---");
        String verufyPhone=sc.next();
        boolean flag=getVerifyId(verifyId,verufyPhone,list);
        if(flag){
            System.out.println("---请修改你的密码---");
            userPassword=sc.next();
            list.get(index).setPassWord(userPassword);
            System.out.println("修改成功,请尝试登陆！");
        }
        else{
            System.out.println("账号信息不匹配，修改失败！");
        }
        return list;
    }
    //验证码功能
    public static  String verifyCode(){
        Random random = new Random();
        //假设四位字母验证码

        StringBuilder verifyCode=new StringBuilder();
        for(int i=0;i<4;i++) {
            if(random.nextBoolean()) {

                //大写字母
                verifyCode.append((char) (random.nextInt(26) + 65));
            }
                else{
                    verifyCode.append((char)(random.nextInt(26)+97));
                }
            }
        //随机生成数字
                verifyCode.append(random.nextInt(10));
        //随机排序
        char[] chars = verifyCode.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = random.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }
    //注册-检查用户名重复功能
    public static int checkUserName(String name, ArrayList<User> list) {

            //判断长度是否在3~15
             if (name.length() < 3 || name.length() > 15) {
               return -2;
            }
            //判断是否为全数字或者全为字母

        boolean isAllDigits = true;
        boolean isAllLower = true;
        boolean isAllUpper = true;
        boolean isAllSpecialChar = false;

        for (int j = 0; j < name.length(); j++) {
            char c = name.charAt(j);
            //发现c不是数字
            if (!Character.isDigit(c)) {
                isAllDigits = false;
            }
            //发现c不是小写字母
            if (!Character.isLowerCase(c)) {
                isAllLower = false;
            }
            //发现c不是大写字母
            if (!Character.isUpperCase(c)) {
                isAllUpper = false;
            }
            //发现c既不是数字也不是字符
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                isAllSpecialChar = true;
            }

            // 提前终止循环，如果已经确定都不是
            if ((!isAllDigits && !isAllLower && !isAllUpper)||isAllSpecialChar) {
                break;
            }
        }

        if (isAllDigits || isAllLower || isAllUpper) {
            return -3;
        }
        else if (isAllSpecialChar) {
            System.out.println("你输入了非法字符！");
            return -3;
        }

                 //判断是否重复
                 for (int i = 0; i < list.size(); i++) {
                     if (name.equals(list.get(i).getUserName())) {
                         return -1;
                     }
                 }

        return 1;
    }
    //注册-检查身份证信息功能
    public static int checkId(String Id){
       //判断Id信息是不是18位数字
        if(Id.length()!=18){
            return -1;
        }
        //判断首位是否为零
        if(Id.charAt(0)=='0'){
            return -2;
        }
        //前十七位里是否有字符
        boolean isFirst17Digits = true;

        for(int i=0;i<Id.length()-1;i++){
            char b=Id.charAt(i);
            //前十七位里是否有字符
            if(!Character.isDigit(b)){
                isFirst17Digits = false;
                //提前终止
                break;
            }
        }
        char lastChar=Id.charAt(Id.length()-1);
        boolean endChar = Character.isDigit(lastChar) || lastChar == 'X' || lastChar == 'x';
        if(!endChar||!isFirst17Digits){
            return -3;
        }
        return 0;
    }
    //注册-检查手机号信息功能
    public static int checkPhone(String Phone){
        //否定条件一：长度不满足11位
        if(Phone.length()!=11){
            return -1;
        }
        if(Phone.charAt(0)=='0'){
            return -2;
        }
        for(int i=0;i<Phone.length();i++){
            char result=Phone.charAt(i);
            //出现非数字返回false
            if(!Character.isDigit(result)){
               return -3;
            }
        }
        return 0;
    }
    //登录-检查用户名和密码重复问题
    public static int checkUserLogin(String username,String password,ArrayList<User> list){
        for (int i = 0; i<list.size();i++) {
            if(username.equals(list.get(i).getUserName())){
                if(password.equals(list.get(i).getPassWord())) {
                    return 0;
                }
            }
        }

        return -1;
    }
   //忘记密码-检查用户身份证号和手机号码匹配问题
   public static boolean getVerifyId(String id, String phone, ArrayList<User> list) {
       for (User user : list) {
           if (id.equals(user.getID()) && phone.equals(user.getPhone())) {
               return true;  // 找到匹配的用户，验证通过
           }
       }
       return false;  // 遍历完仍未找到匹配的用户
   }

}
