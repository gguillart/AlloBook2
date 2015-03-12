package com.table;

/**
 * Created by Yohann on 12/03/2015.
 */
public class Resume {

    int resumeId;
    int livreId;
    String passage;
    String edition;
    String texte;
    int note;

    public Resume(int livreId, String passage, String texte) {
        this.livreId = livreId;
        this.passage = passage;
        this.texte = texte;
    }


    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getLivreId() {
        return livreId;
    }

    public void setLivreId(int livreId) {
        this.livreId = livreId;
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
