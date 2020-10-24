package pl.pjatk.gameplay.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.Model.Player;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    public List<Player> findAll() {
        List<Player> playerList = new ArrayList<>();
        Player player = new Player(1, "Nicknames", 123,15);
        playerList.add(player);
        return playerList;
    }
}
