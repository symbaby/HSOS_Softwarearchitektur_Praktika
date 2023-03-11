package de.hsos.playground;


import javax.enterprise.event.ObservesAsync;
import java.io.Serializable;


public class Greeter implements Serializable {

    public Greeter(){

    }

    public void get(@ObservesAsync Student s){
        System.out.println(s.name + " wurde vom begruesser aufgefangen");
    }
}
