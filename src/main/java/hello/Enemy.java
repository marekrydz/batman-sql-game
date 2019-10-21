package hello;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "enemies")
public class Enemy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nick")
    private String nick;
    @Column(name = "enemy_real_name")
    private String enemyRealName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "heroes_enemies",
            joinColumns = {@JoinColumn(name = "enemy_id")},
            inverseJoinColumns = {@JoinColumn(name = "hero_id")}
    )
    Set<Hero> heroes = new HashSet<>();

    public Enemy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEnemyRealName() {
        return enemyRealName;
    }

    public void setEnemyRealName(String enemyRealName) {
        this.enemyRealName = enemyRealName;
    }

    public Set<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(Set<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", enemyRealName='" + enemyRealName + '\'' +
                '}';
    }
}
