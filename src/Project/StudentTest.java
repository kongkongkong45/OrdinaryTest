package Project;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        //初始信息
        Student s1 = new Student("200", "1", 20, "北京");
        Student s2 = new Student("207", "2", 19, "上海");
        Student s3 = new Student("202", "3", 22, "浙江");
        Student s4 = new Student("205", "4", 20, "江苏");
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------指令有添加，删除，修改，查询，退出------------------");
        System.out.println("请输入你要利用的指令：");
        String choose = sc.next();
        list = Choose(list, choose);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + list.get(i).getName() + list.get(i).getAge() + list.get(i).getAddress());
        }

    }

    //判断是否存在方法
    public static boolean Flag(ArrayList<Student> list, String id) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                flag = true;
            }
        }
        return flag;
    }

    //创建用户的选项
    public static ArrayList<Student> Choose(ArrayList<Student> list, String choose) {
        ArrayList<Student> list1 = new ArrayList<>();
       loop: while (true) {
            switch (choose) {
                case "添加":
                    list1= Add(list, choose);
                    break;
                case "删除":
                    list1 = Remove(list, choose);
                    break;
                case "修改":
                    list1 = Revise(list, choose);
                    break;
                case "查询":
                    Query(list, choose);
                    break;
                case  "退出":break loop;
                default:System.out.println("指令无效，请输入有效指令");
            }
        }
        return list1;
    }

    //添加功能
    public static ArrayList<Student> Add(ArrayList<Student> list, String choose) {
        //先判断id是否存在，存在提示已存在，不存在就添加
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        while (true) {
            System.out.println("请输入学生Id：");
            String id = sc.next();
            if (Flag(list, id)) {
                System.out.println("ID已存在,请重新输入");
            } else {
                student.setId(id);
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        student.setName(sc.next());
        System.out.println("请先输入学生年龄：");
        student.setAge(sc.nextInt());
        System.out.println("请先输入学生家庭住址：");
        student.setAddress(sc.next());
        System.out.println("添加成功！");
        list.add(student);
        return list;
    }

    //删除功能
    public static ArrayList<Student> Remove(ArrayList<Student> list, String choose) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请先输入要删除的学生Id：");
            String id = sc.next();
            if (Flag(list, id)) {  // 如果 ID 存在
                for (int i = 0; i < list.size(); i++) {
                    if (id.equals(list.get(i).getId())) {
                        list.remove(i);  // 删除该学生
                        System.out.println("删除成功！");
                        return list;  // 删除后直接返回修改后的列表
                    }
                }
            } else {
                System.out.println("id不存在，请重新输入！");  // 提示不存在，继续循环
            }
        }
    }
    //修改功能
    public static ArrayList<Student> Revise(ArrayList<Student> list, String choose) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要修改学生的Id：");
            String id = sc.next();
            int index = 0;
            if (Flag(list, id)) {
                //id存在，修改信息
                System.out.println("输入最新的id：");
                String id1 = sc.next();
                System.out.println("输入最新的姓名：");
                String name1 = sc.next();
                System.out.println("输入最新的年龄：");
               int  age1 = sc.nextInt();
                System.out.println("输入最新的家庭地址：");
                String address1 = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (id.equals(list.get(i).getId())) {
                        index = i;
                        list.get(i).setId(id1);
                        list.get(i).setName(name1);
                        list.get(i).setAge(age1);
                        list.get(i).setAddress(address1);
                        return list;
                    }
                }

            } else {
                System.out.println("ID不存在,请重新输入");
            }
        }
    }
    //查询功能
    public static void Query(ArrayList<Student> list, String choose) {
        Scanner sc = new Scanner(System.in);
        if(list.size()==0){
            System.out.println("当前无学生信息，请添加后在使用");
            return;
        }
        System.out.println("请输入要查询信息的学生id（输入exit退出）：");

        while (true) {
            String id = sc.next();

            // 退出条件
            if ("exit".equalsIgnoreCase(id)) {
                break;
            }

            // 先检查ID是否存在
            if (!Flag(list, id)) {
                System.out.println("ID为 " + id + " 的学生不存在，请检查后重试！");
                continue; // 跳过后续处理，继续下一次输入
            }

            // ID存在，查找并打印学生信息
            System.out.println("id\t姓名\t年龄\t家庭地址");
            for (Student student : list) {
                if (id.equals(student.getId())) {
                    System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getAddress());
                    break; // 找到后立即退出循环
                }
            }
        }
    }

}

