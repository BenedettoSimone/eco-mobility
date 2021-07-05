package com.example.eco_mobility.DTO;

import java.sql.Date;

public class ObiettiviDTO {

    int idObiettivi;
    String tipoObiettivo;
    int obiettivo;
    String status;
    Date scadenza;
    int idUtenti;
    int progresso;

    public ObiettiviDTO(){}

    public ObiettiviDTO(int idObiettivi, String tipoObiettivo, int obiettivo, String status, Date scadenza, int idUtenti, int progresso){
        this.idObiettivi=idObiettivi;
        this.tipoObiettivo=tipoObiettivo;
        this.obiettivo=obiettivo;
        this.status=status;
        this.scadenza=scadenza;
        this.idUtenti=idUtenti;
        this.progresso=progresso;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
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


