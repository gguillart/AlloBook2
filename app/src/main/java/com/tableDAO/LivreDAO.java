package com.tableDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.database.DataBase;
import com.table.Livre;

import java.util.ArrayList;

/**
 * Created by Yohann on 12/03/2015.
 */
public class LivreDAO extends DataBase {

    public static final String Key = "Livre_id";
    public static final String Note = "NoteLivre";
    public static final String Titre = "Titre";
    public static final String Annee_De_Parution = "AnneeParution";
    public static final String Description = "Description";
    public static final String Couverture= "Couverture";
    public static final String Table_Name = "Livre";

    public LivreDAO(Context context) {
        super(context);
        open();
    }

    public long ajouter(Livre livre){
        ContentValues value = new ContentValues();
        //value.put(this.Key, livre.getLivreId());
        value.put(this.Titre, livre.getTitre());
        value.put(this.Annee_De_Parution, livre.getAnnee());
        value.put(this.Description, livre.getDescription());
        value.put(this.Note, livre.getNote());
        value.put(this.Couverture, livre.getCouverture());
        return dB.insert(this.Table_Name, null, value);
    }

    public void modifier(Livre livre, int id){

    }

    public void supprimer(int id){

    }

    public Livre selectionner(int id){

        ArrayList<String> auteurs = new ArrayList();
        Livre livre=new Livre("","", auteurs);
        Cursor c = dB.rawQuery("SELECT * FROM " + Table_Name + " WHERE " + Key + "=" + id, null);
        if (c.moveToFirst()) {
            livre.setLivreId(c.getInt(c.getColumnIndex(Key)));
            livre.setTitre(c.getString(c.getColumnIndex(Titre)));
            livre.setAnnee(c.getInt(c.getColumnIndex(Annee_De_Parution)));
            livre.setDescription(c.getString(c.getColumnIndex(Description)));
            livre.setNote(c.getInt(c.getColumnIndex(Note)));
            c.close();
        }
        /*String identifiant = "" + id;
        Cursor c = dB.rawQuery("select " + Note + ", " + Titre + ", " + Annee_De_Parution + ", " +
                Description + ", " + Couverture + ", Auteur_id, NomAuteur, DateNaissance, NomTag, NomGenre from " + Table_Name +
                " NATURAL JOIN LivreAuteur NATURAL JOIN Auteur where " + Key + " = ?" , new String[]{identifiant});

        c.moveToNext();
        int note = c.getInt(0);
        String titre = c.getString(1);
        int annee = c.getInt(2);
        String description = c.getString(3);
        String couverture = c.getString(4);
        int auteurId = c.getInt(5);
        String NomAuteur = c.getString(6);
        String DateNaissance = c.getString(7);

        ArrayList<ArrayList> listeAuteur = new ArrayList<>();
        ArrayList auteur = new ArrayList<>();
        auteur.add(auteurId);
        auteur.add(NomAuteur);
        auteur.add(DateNaissance);
        listeAuteur.add(auteur);

        while(c.moveToNext()){
            int auteurId2 = c.getInt(5);
            String NomAuteur2 = c.getString(6);
            String DateNaissance2 = c.getString(7);
            ArrayList auteur2 = new ArrayList<>();
            auteur2.add(auteurId2);
            auteur2.add(NomAuteur2);
            auteur2.add(DateNaissance2);
            listeAuteur.add(auteur2);
        }


        Livre livre = new Livre(titre, description, listeAuteur);
        livre.setAnnee(annee);
        livre.setCouverture(couverture);
        livre.setNote(note);
        livre.setLivreId(id);

        Cursor c2 = dB.rawQuery("select NomTag from Livre NATURAL JOIN TagLivre NATURAL JOIN Tag where " +
                Key + " = ?" , new String[]{identifiant});

        ArrayList<String> listeTag = new ArrayList<>();

        while(c2.moveToNext()){
            String tag = c2.getString(0);
            listeTag.add(tag);
        }

        livre.setTag(listeTag);


        Cursor c3 = dB.rawQuery("select NomGenre from Livre NATURAL JOIN GenreLivre NATURAL JOIN Genre where " +
                Key + " = ?" , new String[]{identifiant});

        ArrayList<String> listeGenre = new ArrayList<>();
        while(c3.moveToNext()){
            String genre = c3.getString(0);
            listeGenre.add(genre);
        }
        livre.setGenre(listeGenre);*/

        return livre;
    }

    public Livre selectionnerParTitre(String titre){
        Cursor c = dB.rawQuery("select " + Note + ", " + Key + ", " + Annee_De_Parution + ", " +
                Description + ", " + Couverture + ", Auteur_id, NomAuteur, DateNaissance, NomTag, NomGenre from " + Table_Name +
                " NATURAL JOIN LivreAuteur NATURAL JOIN Auteur where " + Titre + " = ?" , new String[]{titre});

        c.moveToNext();
        int note = c.getInt(0);
        int id = c.getInt(1);
        int annee = c.getInt(2);
        String description = c.getString(3);
        String couverture = c.getString(4);
        int auteurId = c.getInt(5);
        String NomAuteur = c.getString(6);
        String DateNaissance = c.getString(7);

        ArrayList<ArrayList> listeAuteur = new ArrayList<>();
        ArrayList auteur = new ArrayList<>();
        auteur.add(auteurId);
        auteur.add(NomAuteur);
        auteur.add(DateNaissance);
        listeAuteur.add(auteur);

        while(c.moveToNext()){
            int auteurId2 = c.getInt(5);
            String NomAuteur2 = c.getString(6);
            String DateNaissance2 = c.getString(7);
            ArrayList auteur2 = new ArrayList<>();
            auteur2.add(auteurId2);
            auteur2.add(NomAuteur2);
            auteur2.add(DateNaissance2);
            listeAuteur.add(auteur2);
        }


        Livre livre = new Livre(titre, description, listeAuteur);
        livre.setAnnee(annee);
        livre.setCouverture(couverture);
        livre.setNote(note);
        livre.setLivreId(id);

        String identifiant = "" + id;
        Cursor c2 = dB.rawQuery("select NomTag from Livre NATURAL JOIN TagLivre NATURAL JOIN Tag where " +
                Key + " = ?" , new String[]{identifiant});

        ArrayList<String> listeTag = new ArrayList<>();

        while(c2.moveToNext()){
            String tag = c2.getString(0);
            listeTag.add(tag);
        }

        livre.setTag(listeTag);


        Cursor c3 = dB.rawQuery("select NomGenre from Livre NATURAL JOIN GenreLivre NATURAL JOIN Genre where " +
                Key + " = ?" , new String[]{identifiant});

        ArrayList<String> listeGenre = new ArrayList<>();
        while(c3.moveToNext()){
            String genre = c3.getString(0);
            listeGenre.add(genre);
        }
        livre.setGenre(listeGenre);

        return livre;
    }
}
