package pl.pjatk.gameplay.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable Long id){
        Optional<Player> byId = playerService.findByID(id);
        if (byId.isPresent()){
            return ResponseEntity.ok(byId.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Player> save(@RequestBody Player player){
        return ResponseEntity.ok(playerService.save(player));
    }
}
