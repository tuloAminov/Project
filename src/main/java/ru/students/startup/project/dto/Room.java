package ru.students.startup.project.dto;

import java.util.Arrays;

public class Room {

    private Long Id;
    private String question;
    private String[] variants;
    private String answer;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getVariants() {
        return variants;
    }

    public void setVariants(String[] variants) {
        this.variants = variants;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + Id +
                ", question='" + question + '\'' +
                ", variants=" + Arrays.toString(variants) +
                ", answer='" + answer + '\'' +
                '}';
    }
}