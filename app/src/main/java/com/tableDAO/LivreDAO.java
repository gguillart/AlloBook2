package com.tableDAO;

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

    SQLiteDatabase db;
    public static final String Key = "Livre_id";
    public static final String Note = "NoteLivre";
    public static final String Titre = "Titre";
    public static final String Annee_De_Parution = "AnneeParution";
    public static final String Description = "Description";
    public static final String Couverture= "Couverture";
    public static final String Table_Name = "Livre";

    public LivreDAO(Context context) {
        super(context);
        db = open();
    }

    public void ajouter(Livre livre){

    }

    public void modifier(Livre livre, int id){

    }

    public void supprimer(int id){

    }

    public Livre selectionner(int id){
        String identifiant = "" + id;
        Cursor c = db.rawQuery("select " + Note + ", " + Titre + ", " + Annee_De_Parution + ", " +
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

        Cursor c2 = db.rawQuery("select NomTag from Livre NATURAL JOIN TagLivre NATURAL JOIN Tag where " +
                Key + " = ?" , new String[]{identifiant});

        ArrayList<String> listeTag = new ArrayList<>();

        while(c2.moveToNext()){
            String tag = c2.getString(0);
            listeTag.add(tag);
        }

        livre.setTag(listeTag);


        Cursor c3 = db.rawQuery("select NomGenre from Livre NATURAL JOIN GenreLivre NATURAL JOIN Genre where " +
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
