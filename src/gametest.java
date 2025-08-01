import org.w3c.dom.ls.LSOutput;

import javax.management.relation.Role;
import java.util.Random;
public class gametest {
    private String name;
    private int blood;
    private char gender;
    private String face;
    String boyface[]={"俊朗", "清秀", "魁梧", "平庸", "邋遢", "阴鸷", "臃肿"};
    String girlface[]={"明眸皓齿", "温婉可人", "亭亭玉立", "秀外慧中", "清丽脱俗", "娇俏灵动", "气质如兰"};
    //攻击描述
    String attacskill[]={"使用了【火焰冲击】：召唤一道炽热的火焰，对敌人造成持续燃烧伤害",
            "使用了【寒冰护甲】：在周身凝结冰晶护盾，大幅提升防御力并反弹部分近战伤害",
            "使用了【暗影步】：瞬间移动到敌人身后发动致命背刺，暴击率提升50%",
            "使用了【神圣治愈】：释放纯净的光明能量，为队友恢复大量生命值",
            "使用了【雷霆震击】：用战锤猛击地面产生冲击波，使范围内敌人陷入眩晕",
            "使用了【毒液喷射】：向前方扇形区域喷洒剧毒，造成持续中毒效果",
            "使用了【鹰眼标记】：标记单个敌人弱点，使团队对其造成的伤害提升30%"};
    //空参
    public gametest() {

    }
    //有参
    public gametest(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        //随机长相
        setFace(gender);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }
    //随机生成人物面貌
    public void setFace(char gender) {
        Random r1=new Random();
        if(gender=='女'){
            this.face=girlface[r1.nextInt(boyface.length)];
        }
        else{
            this.face=boyface[r1.nextInt(girlface.length)];
        }
    }
    //展示双方信息
    public  void showuser(){
        System.out.println("姓名："+getName());
        System.out.println("血量："+getBlood());
        System.out.println("性别："+getGender());
        System.out.println("面部："+getFace());
        System.out.println("=================================");
    }
//第一个 gametest 是参数的类型
//第二个 gametest 是参数的变量名（即参数名称）
    public void attack(gametest gametest) {
        //随机技能描述
        Random r3=new Random();
        int skill=r3.nextInt(attacskill.length);
        String kongfu=attacskill[skill];
        System.out.println(this.getName()+kongfu);
        //随机伤害
        Random rand = new Random();
        int hurt = rand.nextInt(20) + 1;
        //判断被攻击者血量是否为零以及判断受伤状态
        int remainBlood = gametest.getBlood() - hurt;
        remainBlood = remainBlood < 0 ? 0 : remainBlood;
        //返回攻击后的血量
        gametest.setBlood(remainBlood);
        //受伤描述
        if(remainBlood<100&&remainBlood>80){
            System.out.println(gametest.getName()+"骨折：移动速度降低60%，持续受到轻微伤害");
        }
        else if(remainBlood<=80&&remainBlood>=60){
            System.out.println(gametest.getName()+"中毒：每3秒损失生命值，持续15秒");
        }
        else if(remainBlood<60&&remainBlood>40){
            System.out.println(gametest.getName()+"灼烧：防御力下降20%，持续受到火焰伤害");
        }
        else if(remainBlood<=40&&remainBlood>=20){
            System.out.println(gametest.getName()+"致盲：命中率下降75%，持续8秒");
        }
        else if(remainBlood<20){
            System.out.println(gametest.getName()+"流血：每秒钟损失生命值，移动会加速生命流失");
        }
    }

}

