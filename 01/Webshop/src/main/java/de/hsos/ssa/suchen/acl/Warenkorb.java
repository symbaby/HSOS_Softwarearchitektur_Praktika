package de.hsos.ssa.suchen.acl;

import java.util.ArrayList;
import java.util.List;

public class Warenkorb implements IWarenkorbFuerSuche {

    private int warenkorbnummer;
    private List<WareDTO> warenListe;

    public Warenkorb(int warenkorbnummer) {
        this.warenkorbnummer = warenkorbnummer;
        this.warenListe = new ArrayList<>();
    }

    @Override
    public void wareHinzufuegen(WareDTO ware) {
        this.warenListe.add(ware);
    }

    @Override
    public int gebeWarenkorbnummer() {
        return this.warenkorbnummer;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (WareDTO w : warenListe) {
            s.append(w);
        }
        return s.toString();
    }
}
