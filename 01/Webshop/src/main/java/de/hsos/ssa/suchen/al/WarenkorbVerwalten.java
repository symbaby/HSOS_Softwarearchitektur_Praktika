package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.acl.*;

public class WarenkorbVerwalten{

    private WareDTO wareDto;
    private IWarenkorbStaender warenkorbStaender;
    private Warenkorb warenkorb;

    public WarenkorbVerwalten(){
        this.wareDto =  new WareDTO();
        this.warenkorbStaender = new WarenkorbStaenderImpl();
    }

    public Warenkorb holeWarenkorb(){
        warenkorb = warenkorbStaender.holeWarenkorb();
        return warenkorb;
    }

    public Warenkorb holeWarenkorb(int warenkorbnummer){
        warenkorb = warenkorbStaender.holeWarenkorb(warenkorbnummer);
        return warenkorb;
    }


    public WareDTO getWareDto() {
        return wareDto;
    }
}
