package pl.pjatk.gameplay.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String nickName;
    private int health;
    private int attack;

    public Player(){
    }
    public Player(Long id, String nickName, int health, int attack) {
        this.id = id;
        this.nickName = nickName;
        this.health = health;
        this.attack = attack;
    }

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                '}';
    }
}
