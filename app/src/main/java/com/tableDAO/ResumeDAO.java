package com.tableDAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.database.DataBase;
import com.table.Resume;

import java.util.ArrayList;

/**
 * Created by Yohann on 12/03/2015.
 */
public class ResumeDAO extends DataBase {

    SQLiteDatabase db;
    public static final String Key = "Resume_id";
    public static final String Passage = "Passage";
    public static final String Edition = "Edition";
    public static final String Texte = "TexteResume";
    public static final String Note = "NoteResume";
    public static final String Table_Name = "Resume";

    public ResumeDAO(Context context) {
        super(context);
        db = open();
    }

    public void ajouter(Resume resume){

    }

    public void modifier(Resume resume, int id){

    }

    public void supprimer(int id){

    }
//Sélectionne tout les résumés lié à un livre(identifié par son id)
    public ArrayList<Resume> selectionner(int id){

        ArrayList<Resume> liste = new ArrayList<>();
        String identifiant = "" + id;
        Cursor c = db.rawQuery("select " + Note + ", " + Passage + ", " + Edition + ", " +
                Texte + ", " + Key + " from " + Table_Name + " NATURAL JOIN Livre where Livre_id = ?" , new String[]{identifiant});

        while(c.moveToNext()) {
            int note = c.getInt(0);
            String passage = c.getString(1);
            String edition = c.getString(2);
            String texte = c.getString(3);
            int key = c.getInt(4);
            Resume resume = new Resume(id, passage, texte);
            resume.setNote(note);
            resume.setEdition(edition);
            resume.setResumeId(key);
            liste.add(resume);
        }

        return liste;
    }
}
