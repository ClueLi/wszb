package domain;
/*
* 在domain里面放置的都是实体类
* 这是User类对应的是数据库中的user表
* */
public class User {

    private int id;                // 主键，自增长
    private String account ;       // 账号
    private String password;       // 密码
    private String username;       // 用户名称
    private String sex;           // 性别
    private int age;              // 年龄
    private String idcard;         //身份证号
    private String phone;          // 用户手机号
    private String introduce;     // 个人简介
    private String portrait;       //照片存放路径

    public User(){

    }

    public User(int id, String account, String password, String username, String sex, int age, String idcard, String phone, String introduce, String portrait) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.username = username;
        this.sex = sex;
        this.age = age;
        this.idcard = idcard;
        this.phone = phone;
        this.introduce = introduce;
        this.portrait = portrait;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
