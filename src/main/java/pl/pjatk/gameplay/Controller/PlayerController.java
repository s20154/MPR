package pl.pjatk.gameplay.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.Service.DamageService;
import pl.pjatk.gameplay.Service.PlayerService;
import pl.pjatk.gameplay.Model.Player;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() { return ResponseEntity.ok("Hello world"); }

    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable Long id){
        Optional<Player> byId = playerService.findByID(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(byId.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        playerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player){
        return ResponseEntity.ok(playerService.save(player));
    }

    @PutMapping
    public ResponseEntity<Player> update(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.update(player));
    }

    //Nowy mapping w przyjmiemy id 2 graczy i gracz 1 zatakuje gracza 2
    @PutMapping("{attackerId}/{defenderId}")
    public ResponseEntity<Player> attack(int attackerId, int defenderId) {
        return ResponseEntity.ok(PlayerService.attackPlayer(attackerId, defenderId));
    }
}
