package com.example.domushouse;

/**
 * Created by antonio on 31/01/17.
 */

public class Utente {
    private String id;
    private String username;
    private String password;

    public Utente(){
        this.id="";
        this.username="";
        this.password="";

    }

    public Utente(String id,String username,String password){
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
