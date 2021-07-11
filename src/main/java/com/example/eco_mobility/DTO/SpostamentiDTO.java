package com.example.eco_mobility.DTO;

import java.sql.Date;

public class SpostamentiDTO {

    int idSpostamenti;
    Date data;
    int kmPercorsi;
    boolean tipoMezzo;
    int idUtenti;

    public SpostamentiDTO(){}

    public SpostamentiDTO(int idSpostamenti, Date data, int kmPercorsi, boolean tipoMezzo, int idUtenti){
        this.data=data;
        this.idSpostamenti=idSpostamenti;
        this.kmPercorsi=kmPercorsi;
        this.tipoMezzo=tipoMezzo;
        this.idUtenti=idUtenti;
    }

    public int getIdSpostamenti() {
        return idSpostamenti;
    }

    public void setIdSpostamenti(int idSpostamenti) {
        this.idSpostamenti = idSpostamenti;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getKmPercorsi() {
        return kmPercorsi;
    }

    public void setKmPercorsi(int kmPercorsi) {
        this.kmPercorsi = kmPercorsi;
    }

    public boolean isTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(boolean tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public int getIdUtenti() {
        return idUtenti;
    }

    public void setIdUtenti(int idUtenti) {
        this.idUtenti = idUtenti;
    }


}
