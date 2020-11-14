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

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
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
}
