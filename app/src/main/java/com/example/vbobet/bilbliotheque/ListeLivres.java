package com.example.vbobet.bilbliotheque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

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
        ListView listLivres = (ListView) findViewById(R.id.listLivres);
        Importation tacheImport = new Importation();
        tacheImport.execute("fichier d'import");
        try{
            ArrayList<Livre> listeImportee = tacheImport.get();
            if(listeImportee!=null){
                ListeLivresAdapter adapter;
                adapter= new ListeLivresAdapter(getApplicationContext(), listeImportee);
                listLivres.setAdapter(adapter);
                Log.i("Parseur", "ok");
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
}
