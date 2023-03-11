package de.hsos.ssa.katalogverwalten.bl;

public class Geld {
    private final int betrag;
    private final String waehrung;

    public Geld(int betrag, String waehrung) {
        this.betrag = betrag;
        this.waehrung = waehrung;
    }

    public int getBetrag() {
        return betrag;
    }
}
