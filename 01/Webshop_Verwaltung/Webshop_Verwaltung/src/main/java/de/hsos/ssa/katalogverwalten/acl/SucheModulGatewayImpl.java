package de.hsos.ssa.katalogverwalten.acl;

public class SucheModulGatewayImpl implements ISucheModulGateway {


    @Override
    public void createUpdateInSucheWareModul(String name, int preis, String beschreibung) {
        System.out.println("DUMMY: Create wurde an Modul WareSuchen weitergeleitet");
    }

    @Override
    public void deleteUpdateInSucheWareModul(int id) {
        System.out.println("DUMMY: Delete wurde an Modul WareSuchen weitergeleitet");
    }

    @Override
    public void updateUpdateInSucheWareModul(int nummer, String name, int preis, String beschreibung) {
        System.out.println("DUMMY: Update wurde an Modul WareSuchen weitergeleitet");
    }
}
