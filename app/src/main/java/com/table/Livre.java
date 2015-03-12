package com.table;

import java.util.ArrayList;

/**
 * Created by Yohann on 12/03/2015.
 */
public class Livre {

    int livreId;
    String titre;
    int anneeParution;
    String description;
    int note;
    String couverture;
    ArrayList<ArrayList> auteur;
    ArrayList<String> tag;
    ArrayList<String> genre;



    public Livre(String titre, String description, ArrayList auteur){
        this.titre = titre;
        this.description = description;
        this.auteur = auteur;
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

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public ArrayList<ArrayList> getAuteur() {
        return auteur;
    }

    public void setAuteur(ArrayList<ArrayList> auteur) {
        this.auteur = auteur;
    }

    public ArrayList<String> getTag() {
        return tag;
    }

    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }
}
