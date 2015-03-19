package com.example.geoffrey.allobook;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.table.Livre;
import com.tableDAO.LivreDAO;

import java.util.ArrayList;


public class Activity1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> auteurs = new ArrayList(1);
        auteurs.add("Bob");
        Livre livre = new Livre("coucou", "tu veux voir ma bite", auteurs);
        LivreDAO livreDAO = new LivreDAO(this);
        livreDAO.open();
        long id = livreDAO.ajouter(livre);
        /*Livre livre2 = livreDAO.selectionner(1);
        String titre = livre2.getTitre();*/
        setContentView(R.layout.activity_activity1);

        Resources res = getResources();

        String chaine = res.getString(R.string.test, livre.getTitre(), id);
        TextView vue = (TextView)findViewById(R.id.vue);

        vue.setText(chaine);
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
