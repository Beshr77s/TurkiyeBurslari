package com.qashar.turkiyeburslari.Models;

public class Requests {
    private String country;
    private String note;
    private String url;
    private Long date;

    public Requests() {
    }

    public Requests(String country,String url, String note, Long date) {
        this.country = country;
        this.url = url;
        this.note = note;
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
