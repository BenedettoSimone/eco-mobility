package com.example.eco_mobility.DTO;

import java.sql.Date;

public class ObiettiviDTO {

    int idObiettivi;
    String tipoObiettivo;
    int obiettivo;
    boolean status;
    Date scadenza;
    int idUtenti;

    public ObiettiviDTO(){}

    public ObiettiviDTO(int idObiettivi, String tipoObiettivo, int obiettivo, boolean status, Date scadenza, int idUtenti){
        this.idObiettivi=idObiettivi;
        this.tipoObiettivo=tipoObiettivo;
        this.obiettivo=obiettivo;
        this.status=status;
        this.scadenza=scadenza;
        this.idUtenti=idUtenti;
    }

    public int getIdObiettivi() {
        return idObiettivi;
    }

    public void setIdObiettivi(int idObiettivi) {
        this.idObiettivi = idObiettivi;
    }

    public String getTipoObiettivo() {
        return tipoObiettivo;
    }

    public void setTipoObiettivo(String tipoObiettivo) {
        this.tipoObiettivo = tipoObiettivo;
    }

    public int getObiettivo() {
        return obiettivo;
    }

    public void setObiettivo(int obiettivo) {
        this.obiettivo = obiettivo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public int getIdUtenti() {
        return idUtenti;
    }

    public void setIdUtenti(int idUtenti) {
        this.idUtenti = idUtenti;
    }

    @Override
    public String toString() {
        return "ObiettiviDTO{" +
                "idObiettivi=" + idObiettivi +
                ", tipoObiettivo='" + tipoObiettivo + '\'' +
                ", obiettivo=" + obiettivo +
                ", status=" + status +
                ", scadenza=" + scadenza +
                ", idUtenti=" + idUtenti +
                '}';
    }
}


