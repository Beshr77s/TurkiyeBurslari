package com.qashar.turkeyscholiership.Models;

public class News {
    private String text;
    private Long date;

    public News() {
    }

    public News(String text, Long date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
