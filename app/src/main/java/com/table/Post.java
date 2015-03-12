package com.table;

/**
 * Created by Yohann on 12/03/2015.
 */
public class Post {

    int postId;
    int groupeId;
    String date;
    String texte;

    public Post(int groupeId, String texte) {

        this.groupeId = groupeId;
        this.texte = texte;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(int groupeId) {
        this.groupeId = groupeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }


}
