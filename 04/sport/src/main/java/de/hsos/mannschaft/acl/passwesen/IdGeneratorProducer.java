package de.hsos.mannschaft.acl.passwesen;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class IdGeneratorProducer {
    /*
    AtomicInteger id;


    public IdGeneratorProducer(Integer counter){
        this.id = new AtomicInteger(counter);
    }

    @Produces
    public IdGeneration buildAtomicIdGenerator(){
        return new Spielerpass(this.id);
    }
    */

}
