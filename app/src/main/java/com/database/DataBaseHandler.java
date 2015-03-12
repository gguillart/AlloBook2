package com.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Yohann on 19/02/2015.
 */
public class DataBaseHandler extends SQLiteOpenHelper {
    public static final String Auteur_Key = "Auteur_id";
    public static final String Auteur_Nom = "NomAuteur";
    public static final String Auteur_Date_De_Naissance = "DateNaissance";//TODO Définir la forme de la date
    public static final String Auteur_Table_Name = "Auteur";
    public static final String Auteur_Table_Create =
            "CREATE TABLE " + Auteur_Table_Name + " (" +
                    Auteur_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Auteur_Nom + " TEXT NOT NULL, " +
                    Auteur_Date_De_Naissance + " TEXT);";
    public static final String Groupe_Key = "Groupe_id";
    public static final String Groupe_Nom = "NomGroupe";
    public static final String Groupe_Table_Name = "Auteur";
    public static final String Groupe_Table_Create =
            "CREATE TABLE " + Groupe_Table_Name + " (" +
                    Groupe_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Groupe_Nom + " TEXT NOT NULL);";
    public static final String Genre_Nom = "NomGenre";
    public static final String Genre_Table_Name = "Genre";
    public static final String Genre_Table_Create =
            "CREATE TABLE " + Genre_Table_Name + " (" +
                    Genre_Nom + " TEXT PRIMARY KEY NOT NULL);";
    public static final String Tag_Nom = "NomTag";
    public static final String Tag_Table_Name = "Tag";
    public static final String Tag_Table_Create =
            "CREATE TABLE " + Tag_Table_Name + " (" +
                    Tag_Nom + " TEXT PRIMARY KEY NOT NULL);";
    public static final String Livre_Key = "Livre_id";
    public static final String Livre_Note = "NoteLivre";
    public static final String Livre_Titre = "Titre";
    public static final String Livre_Annee_De_Parution = "AnneeParution";
    public static final String Livre_Description = "Description";
    public static final String Livre_Couverture= "Couverture";
    public static final String Livre_Table_Name = "Livre";
    public static final String Livre_Table_Create =
            "CREATE TABLE " + Livre_Table_Name + " (" +
                    Livre_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Livre_Note + " INTEGER, " +
                    Livre_Titre + " TEXT NOT NULL, " +
                    Livre_Annee_De_Parution + " INTEGER, " +
                    Livre_Description + " TEXT, " +
                    Livre_Couverture + " TEXT);";
    public static final String LivreAuteur_Key = "LivreAuteur_id";
    public static final String LivreAuteur_Table_Name = "LivreAuteur";
    public static final String LivreAuteur_Table_Create =
            "CREATE TABLE " + LivreAuteur_Table_Name + " (" +
                    LivreAuteur_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Auteur_Key + " INTEGER NOT NULL REFERENCES " + Auteur_Table_Name + " (" + Auteur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Livre_Key + " INTEGER NOT NULL REFERENCES " + Livre_Table_Name + " (" + Livre_Key + ") ON DELETE CASCADE ON UPDATE CASCADE);";
    public static final String GenreLivre_Key = "GenreLivre_id";
    public static final String GenreLivre_Table_Name = "GenreLivre";
    public static final String GenreLivre_Table_Create =
            "CREATE TABLE " + GenreLivre_Table_Name + " (" +
                    GenreLivre_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Livre_Key + " INTEGER NOT NULL REFERENCES " + Livre_Table_Name + " (" + Livre_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Genre_Nom + " TEXT NOT NULL REFERENCES " + Genre_Table_Name + " (" + Genre_Nom + ") ON DELETE CASCADE ON UPDATE CASCADE);";
    public static final String TagLivre_Key = "TagLivre_id";
    public static final String TagLivre_Table_Name = "TagLivre";
    public static final String TagLivre_Table_Create =
            "CREATE TABLE " + TagLivre_Table_Name + " (" +
                    TagLivre_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Livre_Key + " INTEGER NOT NULL REFERENCES " + Livre_Table_Name + " (" + Livre_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Tag_Nom + " TEXT NOT NULL REFERENCES " + Tag_Table_Name + " (" + Tag_Nom + ") ON DELETE CASCADE ON UPDATE CASCADE);";
    public static final String Utilisateur_Key = "Utilisateur_id";
    public static final String Utilisateur_Pseudo = "Pseudo";
    public static final String Utilisateur_Mail = "Mail";
    public static final String Utilisateur_Mot_De_Passe = "Mdp";
    public static final String Utilisateur_Table_Name = "Utilisateur";
    public static final String Utilisateur_Table_Create =
            "CREATE TABLE " + Utilisateur_Table_Name + " (" +
                    Utilisateur_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Utilisateur_Pseudo + " TEXT NOT NULL, " +
                    Utilisateur_Mail + " TEXT NOT NULL, " +
                    Utilisateur_Mot_De_Passe + " TEXT NOT NULL);";
    public static final String Administrateur_Key = "Administrateur_id";
    public static final String Administrateur_Table_Name = "Administrateur";
    public static final String Administrateur_Table_Create =
            "CREATE TABLE " + Administrateur_Table_Name + " (" +
                    Administrateur_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Utilisateur_Key + " INTEGER NOT NULL REFERENCES " + Utilisateur_Table_Name + " (" + Utilisateur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE);";
    public static final String Post_Key = "Post_id";
    public static final String Post_Date_Du_Post = "DatePost";//TODO définir date
    public static final String Post_Texte = "TextePost";
    public static final String Post_Table_Name = "Post";
    public static final String Post_Table_Create =
            "CREATE TABLE " + Post_Table_Name + " (" +
                    Post_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Groupe_Key + " INTEGER NOT NULL REFERENCES " + Groupe_Table_Name + " (" + Groupe_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Utilisateur_Key + " INTEGER NOT NULL REFERENCES " + Utilisateur_Table_Name + " (" + Utilisateur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Post_Date_Du_Post + " TEXT NOT NULL, " +
                    Post_Texte + " TEXT);";
    public static final String Resume_Key = "Resume_id";
    public static final String Resume_Passage = "Passage";
    public static final String Resume_Edition = "Edition";
    public static final String Resume_Texte = "TexteResume";
    public static final String Resume_Note = "NoteResume";
    public static final String Resume_Table_Name = "Resume";
    public static final String Resume_Table_Create =
            "CREATE TABLE " + Resume_Table_Name + " (" +
                    Resume_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Livre_Key + " INTEGER NOT NULL REFERENCES " + Livre_Table_Name + " (" + Livre_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Utilisateur_Key + " INTEGER NOT NULL REFERENCES " + Utilisateur_Table_Name + " (" + Utilisateur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Resume_Passage + " TEXT NOT NULL, " +
                    Resume_Edition + " TEXT NOT NULL, " +
                    Resume_Texte + " TEXT NOT NULL, " +
                    Resume_Note + " INTEGER);";
    public static final String Note_Key = "Note_id";
    public static final String Note_Note = "Note";
    public static final String Note_Table_Name = "Note";
    public static final String Note_Table_Create =
            "CREATE TABLE " + Note_Table_Name + " (" +
                    Note_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Utilisateur_Key + " INTEGER NOT NULL REFERENCES " + Utilisateur_Table_Name + " (" + Utilisateur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Livre_Key + " INTEGER REFERENCES " + Livre_Table_Name + " (" + Livre_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Resume_Key + " INTEGER REFERENCES " + Resume_Table_Name + " (" + Resume_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Note_Note + " INTEGER);";
    public static final String Commentaire_Key = "Commentaire_id";
    public static final String Commentaire_Date = "DateCommentaire";//TODO à définir
    public static final String Commentaire_Texte = "TexteCommentaire";
    public static final String Commentaire_Table_Name = "Commentaire";
    public static final String Commentaire_Table_Create =
            "CREATE TABLE " + Commentaire_Table_Name + " (" +
                    Commentaire_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Utilisateur_Key + " INTEGER NOT NULL REFERENCES " + Utilisateur_Table_Name + " (" + Utilisateur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Post_Key + " INTEGER REFERENCES " + Post_Table_Name + " (" + Post_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Livre_Key + " INTEGER REFERENCES " + Livre_Table_Name + " (" + Livre_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Resume_Key + " INTEGER REFERENCES " + Resume_Table_Name + " (" + Resume_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Commentaire_Date + " INTEGER NOT NULL, " +
                    Commentaire_Texte + " TEXT NOT NULL);";
    public static final String AdminGroupe_Key = "AdminGroupe_id";
    public static final String AdminGroupe_Table_Name = "AdminGroupe";
    public static final String AdminGroupe_Table_Create =
            "CREATE TABLE " + AdminGroupe_Table_Name + " (" +
                    AdminGroupe_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Groupe_Key + " INTEGER NOT NULL REFERENCES " + Groupe_Table_Name + " (" + Groupe_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Utilisateur_Key + " INTEGER NOT NULL REFERENCES " + Utilisateur_Table_Name + " (" + Utilisateur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE);";
    public static final String Favoris_Key = "Favoris_id";
    public static final String Favoris_Table_Name = "Favoris";
    public static final String Favoris_Table_Create =
            "CREATE TABLE " + Favoris_Table_Name + " (" +
                    Favoris_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Livre_Key + " INTEGER NOT NULL REFERENCES " + Livre_Table_Name + " (" + Livre_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Utilisateur_Key + " INTEGER NOT NULL REFERENCES " + Utilisateur_Table_Name + " (" + Utilisateur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE);";
    public static final String GroupeUtilisateur_Key = "GroupeUtilisateur_id";
    public static final String GroupeUtilisateur_Table_Name = "GroupeUtilisateur";
    public static final String GroupeUtilisateur_Table_Create =
            "CREATE TABLE " + GroupeUtilisateur_Table_Name + " (" +
                    GroupeUtilisateur_Key + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Groupe_Key + " INTEGER NOT NULL REFERENCES " + Groupe_Table_Name + " (" + Groupe_Key + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                    Utilisateur_Key + " INTEGER NOT NULL REFERENCES " + Utilisateur_Table_Name + " (" + Utilisateur_Key + ") ON DELETE CASCADE ON UPDATE CASCADE);";
    public DataBaseHandler(Context context, String nom, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nom, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase dB) {
        dB.execSQL(Auteur_Table_Create + Groupe_Table_Create + Genre_Table_Create + Tag_Table_Create +
                Livre_Table_Create + LivreAuteur_Table_Create + GenreLivre_Table_Create +
                TagLivre_Table_Create + Utilisateur_Table_Create + Administrateur_Table_Create +
                Post_Table_Create + Resume_Table_Create + Note_Table_Create + Commentaire_Table_Create +
                AdminGroupe_Table_Create + Favoris_Table_Create + GroupeUtilisateur_Table_Create);
    }
    //public static final String METIER_TABLE_DROP = "DROP TABLE IF EXISTS " + METIER_TABLE_NAME + ";";
    @Override
    public void onUpgrade(SQLiteDatabase dB, int oldVersion, int newVersion) {
/*dB.execSQL(METIER_TABLE_DROP);
onCreate(dB);*/
//TODO
    }
}