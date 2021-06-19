package com.example.eco_mobility.DTO;

public class PremiDTO {

    int idPremi;
    boolean status;
    int idUtenti;

    public PremiDTO(){
    }

    public PremiDTO(int idPremi, boolean status, int idUtenti){
        this.idPremi=idPremi;
        this.status=status;
        this.idUtenti=idUtenti;
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

    public int getIdUtenti() {
        return idUtenti;
    }

    public void setIdUtenti(int idUtenti) {
        this.idUtenti = idUtenti;
    }
}
