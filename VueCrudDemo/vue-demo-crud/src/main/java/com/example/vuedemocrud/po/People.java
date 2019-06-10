package com.example.vuedemocrud.po;

public class People {
    public static final byte SEX_MAN = 1;
    public static final byte SEX_WOMAN = 2;

    private Integer id;
    private String name;
    private Byte sex;
    private String role;

    @Override
    public String toString() {
        return "People {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", role='" + role + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
