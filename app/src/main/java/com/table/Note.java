package com.table;

/**
 * Created by Yohann on 12/03/2015.
 */
public class Note {

    int noteId;
    int utilisateur;
    int resume;
    int note;

    public Note(int utilisateur, int resume, int note){
        this.utilisateur = utilisateur;
        this.resume = resume;
        this.note = note;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getResume() {
        return resume;
    }

    public void setResume(int resume) {
        this.resume = resume;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
