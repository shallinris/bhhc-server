package com.example.demo.objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity @Table(name = "ANSWERS")
public class Answer {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    private String answer;

    //empty constructor to build generic object
    public Answer() {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Answer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    //getters and setters
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setAnswer(String message) {
        this.answer = message;
    }
    public String getAnswer() {
        return answer;
    }


}
