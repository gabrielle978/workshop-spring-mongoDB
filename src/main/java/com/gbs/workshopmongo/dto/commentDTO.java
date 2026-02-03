package com.gbs.workshopmongo.dto;

import java.util.Date;

public class commentDTO {
    private String text;
    private Date date;
    private authorDTO author;

    public commentDTO(){

    }

    public commentDTO(String text, authorDTO author, Date date) {
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public authorDTO getAuthor() {
        return author;
    }

    public void setAuthor(authorDTO author) {
        this.author = author;
    }
}
