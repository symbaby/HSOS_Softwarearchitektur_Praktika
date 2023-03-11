package de.hsos.ssa.katalogverwalten.al;

import de.hsos.ssa.katalogverwalten.acl.ISucheModulGateway;
import de.hsos.ssa.katalogverwalten.acl.SucheModulGatewayImpl;

public class ParallelUpdate {
    private ISucheModulGateway sucheModulGateway;

    public ParallelUpdate() {
        this.sucheModulGateway = new SucheModulGatewayImpl();
    }

    public void createUpdate(String name, int preis, String beschreibung) {
        this.sucheModulGateway.createUpdateInSucheWareModul(name, preis, beschreibung);
    }

    public void deleteUpdate(int id) {
        this.sucheModulGateway.deleteUpdateInSucheWareModul(id);
    }

    public void updateUpdate(int nummer, String name, int preis, String beschreibung) {
        this.sucheModulGateway.updateUpdateInSucheWareModul(nummer, name, preis, beschreibung);
    }
}
