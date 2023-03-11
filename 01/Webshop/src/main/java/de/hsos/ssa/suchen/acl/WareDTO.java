package de.hsos.ssa.suchen.acl;

import de.hsos.ssa.suchen.bl.Ware;

public class WareDTO {
    private int nummer;
    private String name;
    private int preis; // Hier spaeter mit Geld Klasse
    private String beschreibung;

    public WareDTO() {
    }

    public WareDTO(int nummer, String name, int preis, String beschreibung) {
        this.nummer = nummer;
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
    }


    public WareDTO wareToDTO(Ware ware) {
        WareDTO temp = new WareDTO(ware.getWarennummer(), ware.getName(), ware.getPreis().getBetrag(), ware.getBeschreibung());

        return temp;
    }

    public static class WareDTOBuilder {
        private WareDTO wareDTO;

        public WareDTOBuilder() {
            this.wareDTO = new WareDTO();
        }

        public WareDTOBuilder nummerHinzufuegen(int nummer) {
            this.wareDTO.nummer = nummer;
            return this;
        }

        public WareDTOBuilder nameHinzufuegen(String nummer) {
            this.wareDTO.name = nummer;
            return this;
        }

        public WareDTOBuilder preisHinzufuegen(int preis) {
            this.wareDTO.preis = preis;
            return this;
        }

        public WareDTOBuilder beschreibungHinzufuegen(String beschreibung) {
            this.wareDTO.beschreibung = beschreibung;
            return this;
        }

        public WareDTO build() {
            return this.wareDTO;
        }
    }

    @Override
    public String toString() {
        return "WareDTO{" +
                "nummer=" + nummer +
                ", name='" + name + '\'' +
                ", preis=" + preis +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
