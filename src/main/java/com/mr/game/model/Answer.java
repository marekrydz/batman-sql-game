package com.mr.game.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "game_lvl")
    private String gameLvl;

    @Column(name = "answer_sql")
    private String answerSql;

    @Column(name = "answer_hql")
    private String answerHql;

    public Answer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameLvl() {
        return gameLvl;
    }

    public void setGameLvl(String gameLvl) {
        this.gameLvl = gameLvl;
    }

    public String getAnswerSql() {
        return answerSql;
    }

    public void setAnswerSql(String answerSql) {
        this.answerSql = answerSql;
    }

    public String getAnswerHql() {
        return answerHql;
    }

    public void setAnswerHql(String answerHql) {
        this.answerHql = answerHql;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) &&
                Objects.equals(gameLvl, answer.gameLvl) &&
                Objects.equals(answerSql, answer.answerSql) &&
                Objects.equals(answerHql, answer.answerHql);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameLvl, answerSql, answerHql);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", gameLvl='" + gameLvl + '\'' +
                ", answerSql='" + answerSql + '\'' +
                ", answerHql='" + answerHql + '\'' +
                '}';
    }
}
