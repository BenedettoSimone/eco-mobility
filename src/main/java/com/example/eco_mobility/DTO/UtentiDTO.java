package com.example.eco_mobility.DTO;

public class UtentiDTO {

    int idUtenti;
    String email;
    String password;
    String nome;
    String cognome;

    public UtentiDTO() {
    }

    public UtentiDTO(int idUtenti,String email, String password, String nome, String cognome){
        this.idUtenti=idUtenti;
        this.email=email;
        this.password=password;
        this.nome=nome;
        this.cognome=cognome;
    }

    public int getIdUtenti() {
        return idUtenti;
    }

    public void setIdUtenti(int idUtenti) {
        this.idUtenti = idUtenti;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}