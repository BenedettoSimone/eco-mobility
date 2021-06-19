package com.example.eco_mobility.DTO;

import java.sql.Date;

public class SpeseCarburanteDTO {

    int idSpeseCarburante;
    Date data;
    int euroSpesi;

    public SpeseCarburanteDTO(){
    }

    public SpeseCarburanteDTO(int idSpeseCarburante, Date data, int euroSpesi){
        this.idSpeseCarburante=idSpeseCarburante;
        this.data=data;
        this.euroSpesi=euroSpesi;
    }

    public int getIdSpeseCarburante() {
        return idSpeseCarburante;
    }

    public void setIdSpeseCarburante(int idSpeseCarburante) {
        this.idSpeseCarburante = idSpeseCarburante;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getEuroSpesi() {
        return euroSpesi;
    }

    public void setEuroSpesi(int euroSpesi) {
        this.euroSpesi = euroSpesi;
    }
}
