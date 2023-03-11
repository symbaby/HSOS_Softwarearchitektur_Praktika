package de.hsos.playground;

import java.io.Serializable;

public class Student implements Serializable {

    public int enrollNumber;
    public String name;

    public Student(){

    }

    public Student(int enrollNumber, String name){
        this.enrollNumber = enrollNumber;
        this.name = name;
    }
}
