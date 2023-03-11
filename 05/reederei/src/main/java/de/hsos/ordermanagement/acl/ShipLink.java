package de.hsos.ordermanagement.acl;


import javax.persistence.Embeddable;

@Embeddable
public class ShipLink {
    private String self;

    public ShipLink(){
        this.self = " ";
    }

    public ShipLink(String self) {
        this.self = self;
    }

    public String getSelf() {
        return this.self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

}
