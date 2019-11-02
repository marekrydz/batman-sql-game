package com.mr.game.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String realName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "become_story_id", referencedColumnName = "id")
    private BecomeStory becomeStory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hero")
    private Set<Weapon> weapons;

    @ManyToMany(mappedBy = "heroes")
    private Set<Enemy> enemies = new HashSet<>();

    public Hero() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setBecomeStory(BecomeStory becomeStory) {
        this.becomeStory = becomeStory;
    }

    public BecomeStory getBecomeStory() {
        return becomeStory;
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Set<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Set<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(Set<Enemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(id, hero.id) &&
                Objects.equals(name, hero.name) &&
                Objects.equals(realName, hero.realName) &&
                Objects.equals(becomeStory, hero.becomeStory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, realName, becomeStory);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
