package com.ilhambagoest.soal1.data.entity;

public class DataUser {

    private int id;
    private String name;
    private String position;
    private String birthDate;
    private String urlPhoto;

    public DataUser(int id, String name, String position, String birthDate, String urlPhoto) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.birthDate = birthDate;
        this.urlPhoto = urlPhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
