package com.mr.game;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "game_lvl")
    private int gameLvl;

    @Column(name = "answer_sql")
    private String answerSql;

    public Answer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGameLvl() {
        return gameLvl;
    }

    public void setGameLvl(int gameLvl) {
        this.gameLvl = gameLvl;
    }

    public String getAnswerSql() {
        return answerSql;
    }

    public void setAnswerSql(String answerSql) {
        this.answerSql = answerSql;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return gameLvl == answer.gameLvl &&
                Objects.equals(id, answer.id) &&
                Objects.equals(this.answerSql, answer.answerSql);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameLvl, answerSql);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", gameLvl=" + gameLvl +
                ", answerSql='" + answerSql + '\'' +
                '}';
    }
}
