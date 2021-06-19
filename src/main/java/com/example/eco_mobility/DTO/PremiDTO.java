package com.example.eco_mobility.DTO;

public class PremiDTO {

    int idPremi;
    boolean status;

    public PremiDTO(){
    }

    public PremiDTO(int idPremi, boolean status){
        this.idPremi=idPremi;
        this.status=status;
    }

    public int getIdPremi() {
        return idPremi;
    }

    public void setIdPremi(int idPremi) {
        this.idPremi = idPremi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
