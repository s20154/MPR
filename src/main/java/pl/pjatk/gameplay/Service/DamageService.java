package pl.pjatk.gameplay.Service;

import pl.pjatk.gameplay.Model.Player;
import pl.pjatk.gameplay.Repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

public class DamageService {
    private PlayerRepository playerRepository;
    private DamageService damageService;


    public Player attackPlayer(Player attacker, Player defender){
        defender.setHealth(defender.getHealth() - attacker.getAttack());
        return defender;
    }
}
