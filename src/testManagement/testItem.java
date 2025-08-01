package testManagement;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class testItem {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("---------------欢迎来到学生管理系统---------------");

        System.out.println("请选择你要使用的功能：1登录 2注册 3忘记密码 4退出");

        ArrayList<User> list = new ArrayList<>();
        //选择
        loop:while(true){
            int choose=sc.nextInt();
            switch (choose){
                case 1: list=login( list );break;
                case 2:list=register( list );break;
                case 3:list=forgotPassword( list );break;
                case 4:System.out.println("感谢您的使用！"); break loop;
                default:System.out.println("请输入正确的指令！");break;
            }
        }
    }
    //登录功能
    public static ArrayList<User> login(ArrayList<User> list ){

        //list中没有数据
        if(list.size()==0){
            System.out.println("用户未注册，请先注册！");
            return list ;
        }

        //用户登录用户名

        System.out.println("---请输入要登陆的用户名---");

        String userName = sc.next();

        int check=matchUserName(userName,list);
        if (check==-1) {
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
    public static String  verifyCode(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int count=4;

        //得到四个随机字母
        for(int i=0;i<count;i++){
            if(random.nextBoolean()){
                sb.append(random.nextInt(26)+65);
            }
            else{
                sb.append(random.nextInt(26)+97);
            }
        }

        //得到一个随机数字
        sb.append(random.nextInt(10));

        //随机排序
        char[] chars = sb.toString().toCharArray();
        for(int i=0;i<chars.length;i++){
            int index=random.nextInt(chars.length);
            char temp=chars[i];
            chars[i]=chars[index];
            chars[index]=temp;
        }

        return new String(chars);
    }
    //注册功能
    public static  ArrayList<User>  register(ArrayList<User> list){

        User user=new User();
        //注册用户名
        System.out.println("--------请输入您要注册的用户名--------");
       loop: while (true) {
            String userName=sc.next();
            int check=checkUserName(userName,list);
            if(check==0){
                user.setUserName(userName);
                System.out.println("用户名创建成功！");
                break loop;
            }
           else if(check==-1){
                System.out.println("请重新输入用户名！");
            }
           else if(check==-2){
                System.out.println("请重新输入用户名！");
            }
           else if(check==-3){
                System.out.println("请重新输入用户名！");
            }
           else if(check==-4){
                System.out.println("请重新输入用户名！");
            }
        }

        //注册用户密码
        loop:while (true) {

            System.out.println("--------请输入您要注册的密码--------");
            String password=sc.next();

            int maxAttempts = 2;
            int attempts = 0;
            while (attempts < maxAttempts) {

                System.out.println("请再次输入密码:");
                String matchPassword=sc.next();

                //两次输入的密码不一致
                if(!password.equals(matchPassword)){
                    attempts++;
                    System.out.println("密码错误，您还有"+(maxAttempts-attempts)+"次机会");

                    if(attempts==maxAttempts){
                        System.out.println("密码失效，请重新设置");

                    }
                }

                //两次密码一致
                else{
                    user.setPassword(password);
                    System.out.println("密码一致，添加成功！");
                    break loop;
                }
            }
        }

        //用户注册身份证号
        System.out.println("--------请输入您要注册的身份证号--------");
        while (true) {
            String Id=sc.next();
            int resultCode=checkId(Id);
            if(resultCode==0){
                user.setUserId(Id);
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
                user.setPhoneNumber(phone);
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
        list.add(user);
        return list;
    }

    //忘记密码功能
    public static ArrayList<User>  forgotPassword(ArrayList<User> list) {

        //list中没有数据
        if(list.size()==0){
            System.out.println("用户未注册，请先注册！");
            return  list;
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
            return list;
        }



        System.out.println("---请输入身份证号---");
        String verifyId=sc.next();
        System.out.println("---请输入手机号---");
        String verufyPhone=sc.next();
        boolean flag=getVerifyId(verifyId,verufyPhone,list);
        if(flag){
            System.out.println("---请修改你的密码---");
            userPassword=sc.next();
            list.get(index).setPassword(userPassword);
            System.out.println("修改成功,请尝试登陆！");
        }
        else{
            System.out.println("账号信息不匹配，修改失败！");
        }
        return list;
    }
    //注册-判断用户名形式问题
    public static int checkUserName(String name, ArrayList<User> list){
        if(name.length()<3||name.length()>15){
            System.out.println("不在要求长度范围内！");
            return -1;//不在要求长度范围内
        }

        // 首先检查是否包含非法字符（非字母数字）
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            if(!Character.isDigit(c) && !Character.isLowerCase(c) && !Character.isUpperCase(c)) {
                System.out.println("您输入了非法字符！");
                return -2;
            }
        }

        //判断全数字，全大写字母或者全小写字母的情况，
        boolean isAllDigit=true;
        boolean isAllLower=true;
        boolean isAllUpper=true;
        for(int i=0;i<name.length();i++){

            //出现非数字情况
            if(!Character.isDigit(name.charAt(i))){
                isAllDigit=false;
            }

            //出现非小写字母情况
            if(!Character.isLowerCase(name.charAt(i))){
                isAllLower=false;
            }

            //出现非大写字母情况
            if(!Character.isUpperCase(name.charAt(i))){
                isAllUpper=false;
            }


        }

        if(isAllDigit||isAllLower||isAllUpper){
            System.out.println("用户名不能是纯字符！");
            return -2;
        }

        //用户名唯一的问题
        int check=matchUserName(name,list);
        //用户名重复
        if(check>0){
            System.out.println("用户名重复！");
            return -4;
        }

        return 0;
    }
    //判断用户名重复问题
    public static int matchUserName(String name, ArrayList<User> list){
       int index=-1;

       for(int i=0;i<list.size();i++){
            if(name.equals(list.get(i).getUserName())){
                index=i;
            }
       }
       return index;
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
    public static int checkUserLogin(String name,String password,ArrayList<User> list){
        int index=matchUserName(name, list);
        if( index>=0) {
            for (int i = 0; i < list.size(); i++) {

                if (password.equals(list.get(index).getPassword())) {
                    return 0;
                }

            }
        }
        return -1;
    }
    //忘记密码-检查用户身份证号和手机号码匹配问题
    public static boolean getVerifyId(String id, String phone, ArrayList<User> list) {
        for (User user : list) {
            if (id.equals(user.getUserId()) && phone.equals(user.getPhoneNumber())) {
                return true;  // 找到匹配的用户，验证通过
            }
        }
        return false;  // 遍历完仍未找到匹配的用户
    }
}
