package de.hsos.mannschaft.gateway;

import de.hsos.mannschaft.entity.IPlayersCatalogue;
import de.hsos.mannschaft.entity.Links;
import de.hsos.mannschaft.entity.Player;
import de.hsos.mannschaft.utils.dto.patch.PlayerAttributesPatch;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ApplicationScoped
public class PlayerRepository implements IPlayersCatalogue {

    // Dummy
    Map<String, Player> playerMap = new ConcurrentHashMap<>();

    public PlayerRepository() {
        Player p1 = new Player("Lil Smogmog", "Spieler", "98", new Links("localhost:8080/players/1", " "));
        Player p2 = new Player("Berkan", "Spieler", "99", new Links("localhost:8080/players/2", " "));

        playerMap.put(p1.getId(), p1);
        playerMap.put(p2.getId(), p2);
    }

    @Override
    public boolean setPlayerCondition(String id, PlayerAttributesPatch playerAttributesPatch) {
        if (this.playerMap.containsKey(id)) {
            Player tmp = this.playerMap.get(id);

            tmp.setCondition(playerAttributesPatch.condition);
            System.out.println(this.playerMap);
            return true;
        }

        return false;
    }
}
