package ru.job4j.Professions;

public class Profession {
    private String name;
    private String profession;

    public void setName(String name){
        this.name = name;
    }

    public void setProfession(String profession){
        this.profession = profession;
    }

    public String getName(){
        return this.name;
    }

    public String getProfession() {
        return this.profession;
    }
}
