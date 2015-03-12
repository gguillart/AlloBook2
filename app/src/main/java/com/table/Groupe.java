package com.table;

import java.util.ArrayList;

/**
 * Created by Yohann on 12/03/2015.
 */
public class Groupe {

    int groupeId;
    String nom;
    int adminId;
    ArrayList<Integer> utilisateurId;

    public Groupe(String nom, int admin, ArrayList<Integer> utilisateurs){
        this.nom = nom;
        this.adminId = admin;
        this.utilisateurId = utilisateurs;
    }

    public  void setGroupeId(int groupe){
        groupeId = groupe;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setAdmin(int admin){
        this.adminId = admin;
    }

    public void setUtilisateurs(int user){
        utilisateurId.add(user);
    }

    public int getGroupeId(){
        return groupeId;
    }

    public String getNom(){
        return nom;
    }

    public int getAdmin(){
        return adminId;
    }

    public ArrayList<Integer> getUtilisateurs(){
        return utilisateurId;
    }
}
