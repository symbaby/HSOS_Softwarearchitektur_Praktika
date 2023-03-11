import de.hsos.ssa.suchen.database.Database;
import de.hsos.swa.ssa.ui.view.SimpleShoppingAppControl;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection con = Database.getConnection();
        if (con != null) {
            System.out.println("Verbindung zur Datenbank erfolgreich");
        } else {
            System.err.println("Verbindung zur Datenbank fehlgeschlagen");
        }

        SimpleShoppingAppControl shop = new SimpleShoppingAppControl();
        shop.begruessung();




    }
}
