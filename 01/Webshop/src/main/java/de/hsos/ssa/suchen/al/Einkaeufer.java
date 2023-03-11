package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.acl.IWarenkorbFuerSuche;
import de.hsos.ssa.suchen.acl.Warenkorb;
import de.hsos.ssa.suchen.bl.Produktinformation;
import de.hsos.ssa.suchen.bl.Ware;

import java.sql.SQLException;


public class Einkaeufer implements IHoleWarenkorb, IPruefeWare, ISucheWare, IWaehleWare {
    private HoleWarenkorbImpl holeWarenkorb;
    private PruefeWareImpl pruefeWare;
    private SucheWareImpl sucheWare;
    private WaehleWareImpl waehleWare;


    // private WarenkorbVerwalten warenkorbVerwalten;
    private Warenkorb warenkorb;

    public Einkaeufer() {
        this.holeWarenkorb = new HoleWarenkorbImpl();
        this.pruefeWare = new PruefeWareImpl();
        this.sucheWare = new SucheWareImpl();
        this.waehleWare = new WaehleWareImpl();
    }


    // Das der Einkaufer IHoleWarenkorb, IPruefeWare, ISucheWare, IWaehleWare aus den Grund damit wir ein "Vertrag" haben das die Methoden immer implementiert werden
    // Ausserdem ist der Einkaufer auch vom Typ: IHoleWarenkorb, IPruefeWare, ISucheWare, IWaehleWare... nutzlich beim Dependency Injection bei aufrufenden Klassen
    // Der Sinn von den Delegationsmethoden ist, dass implementierungen gekapselt werden sollen
    // Ähnlich wie vom SRP Beispiel aus der VL. Wenn es aenderungen bei einer Implementation eines Interfaces gibt dann soll nicht
    // hier in den Methoden "rumgepfuscht" werden sondern die Implementation soll ausgestauscht werden.
    // Z.B.  this.holeWarenkorb = new HoleWarenkorbImplV2();
    // Die entsprechende Abteilung kann dann beliebig erweitern und muss nicht andere Implementationen von anderen Abteilungen sehen!


    @Override
    public IWarenkorbFuerSuche holeWarenkorb() {
        this.warenkorb = (Warenkorb) this.holeWarenkorb.holeWarenkorb();
        return warenkorb;
    }

    @Override
    public IWarenkorbFuerSuche holeWarenkorb(int warenkorbnummer) {
        this.warenkorb = (Warenkorb) this.holeWarenkorb.holeWarenkorb(warenkorbnummer);

        System.out.println("Warenkorb " + warenkorb + " mit Nummer " + warenkorbnummer + " wurde geholt");
        return warenkorb;
    }

    @Override
    public Produktinformation holeDetailinformationen(Ware ware) {
        return this.pruefeWare.holeDetailinformationen(ware);
    }

    @Override
    public Ware sucheWare(String warenname) throws SQLException {
        return this.sucheWare.sucheWare(warenname);
    }

    @Override
    public Ware sucheWare(int warennummer) throws SQLException {
        return this.sucheWare.sucheWare(warennummer);
    }

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware, IWarenkorbFuerSuche warenkorb) {
        return this.waehleWare.wareZuWarenkorbHinzufuegen(ware, warenkorb);
    }


}
