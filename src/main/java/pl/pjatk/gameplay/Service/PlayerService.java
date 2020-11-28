package pl.pjatk.gameplay.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.Model.Player;
import pl.pjatk.gameplay.Repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private DamageService damageService;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
        this.damageService = damageService;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findByID(Long playerId){
        return playerRepository.findById(playerId);
    }

    public Player save(Player player){
        return playerRepository.save(player);
    }

    public void deleteById(Player player){
        playerRepository.deleteById(player.getId());
    }

    public Player update(Player player) {
        Optional<Player> byId = playerRepository.findById(player.getId());
        if(byId.isEmpty()){
            throw new RuntimeException();
        } else {
            return playerRepository.save(Player);
        }
    }

    //Metoda metode ktory przyjmie atak z CONTR i przekaze gotowe obiekty do DamageService
    public Player attackPlayer(Long attackerId, Long defenderId) {
        Player attacker = findByID(attackerId).get();
        Player defender = findByID(defenderId).get();
        defender = damageService.attackPlayer(attacker, defender);
        return update(defender);
    }


    //DamageService ktory przejmie obiekty i zada obrażenia NIE DODAWAC ZALEZNOSCIINNYCH SERWISOW
    //Zapisac zmianny
    //Zwrocic gracza broniącego
}
