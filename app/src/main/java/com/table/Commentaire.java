package com.table;

/**
 * Created by Yohann on 12/03/2015.
 */
public class Commentaire {

    int commentaireId;
    int utilisateurId;
    int postId;
    int livreId;
    int resumeId;
    String date;
    String texte;

    public Commentaire(int user, String text) {
        utilisateurId = user;
        texte = text;
    }

    public void setCommentaireId(int commentaire){
        this.commentaireId = commentaire;
    }

    public void setPostId(int post){
        this.postId = post;
    }

    public void setLivreId(int livre){
        this.livreId = livre;
    }

    public void setResume(int resume){
        this.resumeId = resume;
    }

    public int getCommentaireId(){
        return commentaireId;
    }

    public int getPostId(){
        return postId;
    }

    public int getLivreId(){
        return livreId;
    }

    public int getResume(){
        return resumeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
