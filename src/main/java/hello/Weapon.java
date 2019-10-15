package hello;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weapons")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String characteristic;

    public Weapon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(id, weapon.id) &&
                Objects.equals(name, weapon.name) &&
                Objects.equals(characteristic, weapon.characteristic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, characteristic);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characteristic='" + characteristic + '\'' +
                '}';
    }
}
