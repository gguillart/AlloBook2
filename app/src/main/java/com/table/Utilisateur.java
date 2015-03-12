package com.table;

import java.util.ArrayList;

/**
 * Created by Yohann on 12/03/2015.
 */
public class Utilisateur {

    int utilisateurId;
    String pseudo;
    String mail;
    String mdp;
    int admin;
    ArrayList<Integer> adminGroupe;
    ArrayList<Integer> groupe;
    ArrayList<Integer> favoris;

    public Utilisateur(String pseudo, String mail, String mdp) {
        this.pseudo = pseudo;
        this.mail = mail;
        this.mdp = mdp;
        groupe = new ArrayList<>();
        favoris = new ArrayList<>();
        adminGroupe = new ArrayList<>();
        admin = 0;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public ArrayList<Integer> getAdminGroupe() {
        return adminGroupe;
    }

    public ArrayList<Integer> getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe.add(groupe);
    }

    public ArrayList<Integer> getFavoris() {
        return favoris;
    }

    public void setFavoris(int favoris) {
        this.favoris.add(favoris);
    }

    public void setAdminGroupe(int adminGroupe) {
        this.adminGroupe.add(adminGroupe);
    }
}
