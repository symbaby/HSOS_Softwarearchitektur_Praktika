package de.hsos.mannschaft.utils.dto.get;

public class ManagerGet {
    public ManagerBasicDataGet basicData;
    public ManagerLinksGet links;

    public ManagerGet(){
        this.basicData = new ManagerBasicDataGet();
        this.links = new ManagerLinksGet();
    }
}
