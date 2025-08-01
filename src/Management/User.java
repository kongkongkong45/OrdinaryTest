package Management;

public class User {
    String UserName;
    String PassWord;
    String ID;
    String Phone;

    public User() {
    }

    public User(String userName, String passWord, String ID, String phone) {
        UserName = userName;
        PassWord = passWord;
        this.ID = ID;
        Phone = phone;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
