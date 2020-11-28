package pl.pjatk.gameplay.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pjatk.gameplay.Model.Player;
import pl.pjatk.gameplay.Service.DamageService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DamageServiceTest {

    private DamageService damageService = new DamageService();

    @Test
    void shouldHealPlayer(){
        //given
        Player player = new Player("mynickname", 20, 5);
        //when
        damageService.heal(player);
        //then
        assertThat(player.getHealth()).isEqualTo(30);
    }

    @Test
    void shouldSwapHealtAttack(){
        Player player = new Player("mynickname", 20, 5);
        damageService.swapStats(player);
        assertThat(player.getHealth() == 5 && player.getAttack() == 20);
    }

    @Test
    void shouldDoubleAttack(){
        Player player = new Player("mynickname", 1, 5);
        damageService.berserk(player);
        assertThat(player.getAttack() == 2*5);
    }

    @Test
    void shouldDecreaseHealth(){
        Player player = new Player("mynickname", 40, 5);
        damageService.berserk(player);
        assertThat(player.getHealth() == 30);
    }

    @Test
    void testDiceRoll(){
        Player player = new Player("mynickname", 40, 5);
        damageService.rollDice(player);
        assertThat(player.getHealth() >= 0 && player.getAttack() >= 0);
    }

}
