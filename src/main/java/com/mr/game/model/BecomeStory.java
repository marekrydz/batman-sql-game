package com.mr.game.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="become_stories")
public class BecomeStory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String place;

    private String how;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "becomeStory")
    private Hero hero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BecomeStory that = (BecomeStory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(place, that.place) &&
                Objects.equals(how, that.how) &&
                Objects.equals(hero, that.hero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, how, hero);
    }

    @Override
    public String toString() {
        return "BecomeStory{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", how='" + how + '\'' +
                ", hero=" + hero +
                '}';
    }
}
