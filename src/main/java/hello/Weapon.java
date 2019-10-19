package hello;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weapons")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "weapons_names")
    String weaponName;
    String characteristic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hero_id")
    Hero hero;

    public Weapon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
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
        Weapon weapon = (Weapon) o;
        return Objects.equals(id, weapon.id) &&
                Objects.equals(weaponName, weapon.weaponName) &&
                Objects.equals(characteristic, weapon.characteristic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weaponName, characteristic);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", weaponName='" + weaponName + '\'' +
                ", characteristic='" + characteristic + '\'' +
                '}';
    }
}
