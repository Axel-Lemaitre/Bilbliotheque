package com.example.vbobet.bilbliotheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import metier.Importation;
import metier.ListeLivresAdapter;
import metier.Livre;

public class ListeLivres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_livres);
        Importation tacheImport = new Importation();
        tacheImport.execute("http://10.0.2.2:3000/android/");
        ListView listLivres = (ListView) findViewById(R.id.listLivres);
        try{
            ArrayList<Livre> listeImportee = tacheImport.get();
            if(listeImportee!=null){
                ListeLivresAdapter adapter;
                adapter= new ListeLivresAdapter(getApplicationContext(), listeImportee);
                listLivres.setAdapter(adapter);
                Log.i("Parseur", "ok");

                listLivres.setOnItemClickListener(observateurClickItem);
            }
            else {
                Log.i("Parseur", "Problèmes lors de la lecteur du ficher");
            }
        } catch (InterruptedException e) {
            Log.i("Parseur", "Interruption lecture fichier"+e.getMessage());
        } catch (ExecutionException e) {
            Log.i("Parseur", "Erreur execution " +e.getMessage());
        }
    }

    private AdapterView.OnItemClickListener observateurClickItem = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent i;
            i = new Intent(getApplicationContext(), Detail.class);
            i.putExtra("Livre",((Livre) parent.getItemAtPosition(position)).getTitre());
            startActivity(i);
        }
    };

}

