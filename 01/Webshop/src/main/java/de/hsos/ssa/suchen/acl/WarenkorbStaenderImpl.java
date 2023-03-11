package de.hsos.ssa.suchen.acl;

import java.util.HashMap;

public class WarenkorbStaenderImpl implements IWarenkorbStaender {

    private HashMap<Integer, Warenkorb> warenkoerbe;

    public WarenkorbStaenderImpl() {
        this.warenkoerbe = new HashMap<>();

        // Ab hier dummy Werte
        Warenkorb w1 = new Warenkorb(1);
        Warenkorb w2 = new Warenkorb(2);
        Warenkorb w3 = new Warenkorb(3);

        WareDTO ware1 = new WareDTO(1, "Controller", 60, "Xbox Controller");
        WareDTO ware2 = new WareDTO(2, "Tastatur", 130, "Ducky One 2 Mini");
        WareDTO ware3 = new WareDTO(3, "Mausepad", 75, "Hayabusa Mousepad");

        w1.wareHinzufuegen(ware1);
        w2.wareHinzufuegen(ware2);
        w3.wareHinzufuegen(ware3);

        warenkoerbe.put(w1.gebeWarenkorbnummer(), w1);
        warenkoerbe.put(w2.gebeWarenkorbnummer(), w2);
        warenkoerbe.put(w3.gebeWarenkorbnummer(), w3);
    }

    @Override
    public Warenkorb holeWarenkorb() {
        // DUMMY
        // Hier vielleicht die ID vom Einkauefer bei Programmstart rein?
        return new Warenkorb(0);
    }

    @Override
    public Warenkorb holeWarenkorb(int warenkorbnummer) {
        if (warenkoerbe.containsKey(warenkorbnummer)) {
            return this.warenkoerbe.get(warenkorbnummer);
        } else {
            throw new IllegalArgumentException("Warenkorb existiert nicht! Versuch die Dummy Werte 1 - 3");
        }
    }
}
