package com.table;

/**
 * Created by Yohann on 12/03/2015.
 */
public class Livre {

    int livreId;
    String titre;
    int anneeParution;
    String description;
    int note;


    public Livre(String titre, String description){
        this.titre = titre;
        this.description = description;
    }

    public void setLivreId(int livre){
        livreId = livre;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setAnnee(int annee){
        this.anneeParution = annee;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setNote(int note){
        this.note = note;
    }

    public int getLivreId(){
        return livreId;
    }

    public String getTitre(){
        return titre;
    }

    public int getAnnee(){
        return anneeParution;
    }

    public String getDescription(){
        return description;
    }

    public int getNote(){
        return note;
    }
}
