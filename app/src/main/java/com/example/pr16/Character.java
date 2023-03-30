package com.example.pr16;

public class Character {
    private int ID_Char;
    private String Name_Char;
    private String Class_Char;


    public Character(int ID_Char, String name_Char, String class_Char) {
        this.ID_Char = ID_Char;
        Name_Char = name_Char;
        Class_Char = class_Char;
    }

    public int getID_Char() {
        return ID_Char;
    }

    public void setID_Char(int ID_Char) {
        this.ID_Char = ID_Char;
    }

    public String getName_Char() {
        return Name_Char;
    }

    public void setName_Char(String name_Char) {
        Name_Char = name_Char;
    }

    public String getClass_Char() {
        return Class_Char;
    }

    public void setClass_Char(String class_Char) {
        Class_Char = class_Char;
    }
}
