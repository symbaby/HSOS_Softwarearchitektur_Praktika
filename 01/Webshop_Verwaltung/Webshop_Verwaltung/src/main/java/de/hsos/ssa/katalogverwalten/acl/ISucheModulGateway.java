package de.hsos.ssa.katalogverwalten.acl;

public interface ISucheModulGateway {

    public void createUpdateInSucheWareModul(String name, int preis, String beschreibung);

    public void deleteUpdateInSucheWareModul(int id);

    public void updateUpdateInSucheWareModul(int nummer, String name, int preis, String beschreibung);

}
