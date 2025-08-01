public class game {
    public static void main(String[] args) {
        gametest role1 = new gametest("小汪",100,'男');
        gametest role2=new gametest("33",100,'男');
        System.out.println("比赛开始：");
        System.out.println("=================================");
        role1.showuser();
        role2.showuser();
        System.out.println("=================================");
      while(true){
          role1.attack(role2);
          if(role2.getBlood()==0){
              System.out.println(role1.getName()+"KO了"+role2.getName());
              break;
          }
          role2.attack(role1);
          if(role1.getBlood()==0){
              System.out.println(role2.getName()+"KO了"+role1.getName());
              break;
          }
      }
    }
}
