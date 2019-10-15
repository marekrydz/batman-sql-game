package hello;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String realName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "become_story_id", referencedColumnName = "id")
    private BecomeStory becomeStory;

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

    public BecomeStory getBecomeStory() {
        return becomeStory;
    }

    public void setBecomeStory(BecomeStory becomeStory) {
        this.becomeStory = becomeStory;
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
