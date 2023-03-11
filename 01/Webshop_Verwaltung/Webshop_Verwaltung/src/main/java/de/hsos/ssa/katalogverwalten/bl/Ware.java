package de.hsos.ssa.katalogverwalten.bl;

public class Ware {
    private int warennummer;
    private String name;
    private String beschreibung;
    private Geld preis;
    private Produktinformation produktinformation;

    public static class WareBuilder {
        private Ware ware;

        public WareBuilder() {
            this.ware = new Ware();
        }

        public WareBuilder warennummerHinzufuegen(int warennummer) {
            this.ware.warennummer = warennummer;
            return this;
        }

        public WareBuilder nameHinzufuegen(String name) {
            this.ware.name = name;
            return this;
        }

        public WareBuilder beschreibung(String beschreibung) {
            this.ware.beschreibung = beschreibung;
            return this;
        }

        public WareBuilder preisHinzufuegen(Geld preis) {
            this.ware.preis = preis;
            return this;
        }

        public WareBuilder produktInformationHinzufuegen(Produktinformation produktinformation) {
            this.ware.produktinformation = produktinformation;
            return this;
        }

        public Ware build() {
            return this.ware;
        }

    }

    public Produktinformation getProduktinformation() {
        return produktinformation;
    }

    public int getWarennummer() {
        return warennummer;
    }

    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Geld getPreis() {
        return preis;
    }

    @Override
    public String toString() {
        return "Ware{" +
                "warennummer=" + warennummer +
                ", name='" + name + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", preis=" + preis +
                ", produktinformation=" + produktinformation +
                '}';
    }
}
