package pl.pjatk.gameplay.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.gameplay.Model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
