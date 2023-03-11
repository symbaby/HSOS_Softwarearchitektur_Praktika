package de.hsos.playground;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.Serializable;


@ApplicationScoped
public class StudentManager implements Serializable {

    @Inject
    Event<Student> event;

    public StudentManager(){

    }

     public void enroll(String name){
        int enrollNumber = 10;
        Student s = new Student(enrollNumber, name);
        this.event.fireAsync(s);
     }
}
