package Student;

public class Student {
    public  static void main(String[] args) {
        StudentNew s1 = new StudentNew(001, "33", 20);
        StudentNew s2 = new StudentNew(002, "小胡", 21);
        StudentNew s3 = new StudentNew(003, "小汪", 22);
        StudentNew arr[] = new StudentNew[4];
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;
        //添加一个数据并判断学号是否重复
        StudentNew s4 = new StudentNew(004, "werwer", 3);
        //判断学号是否重复
        boolean flag = countain(arr, s4.getId());
        //如果不重复，继续判断数组状态
        if(!flag){
            if(arr[arr.length-1]==null){
                arr[arr.length-1] = s4;
                show(arr);
                //根据id删除相关信息并再一次遍历数组
                //找到id所对应的索引，返回能找到id索引的值，并对对应的值进行删除操作
                int index=SearchId(arr,3);
                if(index>=0){
                    System.out.println("存在该id并进行删除操作");
                    arr[index]=null;
                    show(arr);
                }
                else{
                    System.out.println("不存在该id");
                }
                //找到想要id的索引，并将其年龄加1
                int index1=SearchId(arr,2);
                if(index1>=0){
                    System.out.println("存在该id并进行年龄加1操作");
                    int i=arr[index1].getAge()+1;
                    arr[index1].setAge(i);
                }
                else{
                    System.out.println("不存在该id");
                }
                System.out.println("最终结果展示：");
                show(arr);
            }
            //数组满了，创建一个新的数组
            else{
                StudentNew[] NewArr= NewArr(arr,s4);
                show(NewArr);
                //根据id删除相关信息并再一次遍历数组
                //找到id所对应的索引，返回能找到id索引的值，并对对应的值进行删除操作
                int index=SearchId(NewArr,5);
                if(index>=0){
                    System.out.println("存在该id，进行删除");
                    NewArr[index]=null;
                    show(NewArr);
                }
                else{
                    System.out.println("不存在该id，删除失败");
                }
                //找到想要id的索引，并将其年龄加1
                int index1=SearchId(NewArr,2);
                if(index1>=0){
                    System.out.println("存在该id并进行年龄加1操作");
                    int i=NewArr[index1].getAge()+1;
                    NewArr[index1].setAge(i);
                }
                else{
                    System.out.println("不存在该id");
                }
                System.out.println("最终结果展示：");
                show(NewArr);
            }
        }
        else{
            System.out.println("学号重复请重新输入一个新的学号");
        }
    }
    //判断id重复的方法
    public  static boolean countain(StudentNew arr[],int id){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null&&arr[i].getId()==id){
                return true;
            }
        }
        return false;
    }
    //创建新的数组
    public static StudentNew[] NewArr(StudentNew arr[], StudentNew s){
        StudentNew Newarr[] = new StudentNew[arr.length+1];
        for(int i=0;i<arr.length;i++){
            Newarr[i] = arr[i];
        }
        Newarr[arr.length] = s;
        return Newarr;
    }
    //遍历数组信息
    public static void show(StudentNew[] arr) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != null) {
                System.out.println(arr[j].getId() + " " + arr[j].getName() + " " + arr[j].getAge());
            }
        }
    }
    //寻找要删除的id索引
    public static int SearchId(StudentNew[] arr,int id){
        int n=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null&&arr[i].getId()==id){
                n=i;
                return n;
            }
        }
        return -1;
    }

}
