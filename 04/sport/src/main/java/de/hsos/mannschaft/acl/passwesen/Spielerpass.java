package de.hsos.mannschaft.acl.passwesen;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@IPlayer
public class Spielerpass implements IdGeneration, Serializable {

    /*
    AtomicInteger id;

    public Spielerpass(AtomicInteger id){
        this.id = id;
    }

    @Override
    public String newID() {
        return id.incrementAndGet() + "";
    }

  */
    @Override
    public String newID() {
        return " ";
    }


}
