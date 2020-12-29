package snowdrop.nnt.ontapck;

public class User {
    private int id;
    private String name;
    private int age;
    private String email;
    private String gioiTinh;

    public User() {
    }

    public User(String name, int age, String email, String gioiTinh) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }

    //    public User(int id, String name, int age, String email) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.email = email;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
