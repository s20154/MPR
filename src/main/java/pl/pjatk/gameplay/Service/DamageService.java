package pl.pjatk.gameplay.Service;

import pl.pjatk.gameplay.Model.Player;
import pl.pjatk.gameplay.Repository.PlayerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class DamageService {
    private PlayerRepository playerRepository;
    private DamageService damageService;


    public Player attackPlayer(Player attacker, Player defender){
        defender.setHealth(defender.getHealth() - attacker.getAttack());
        return defender;
    }

    public Player heal(Player player){
        player.setHealth(player.getHealth() + 10);
        return player;
    }

    public Player swapStats(Player player){
        int tmp = player.getAttack();
        player.setAttack(player.getHealth());
        player.setHealth(tmp);
        return player;
    }

    public Player berserk(Player player){
        if(player.getHealth() < 5) {
            player.setAttack(player.getAttack() * 2);
        } else {
            player.setHealth(player.getHealth() - 10);
        }
        return player;
    }

    public Player rollDice(Player player){
        Random rand = new Random();
        switch (rand.nextInt(6)){
            case 0:
                player.setHealth(player.getHealth()+20);
                break;
            case 1:
                player.setHealth(10);
                break;
            case 2:
                player.setAttack(player.getAttack()+15);
                break;
            case 3:
                player.setAttack(5);
                break;
            case 4:
                player.setAttack(player.getHealth());
                break;
            case 5:
                player.setHealth(0);
                break;
        }
    }
}


