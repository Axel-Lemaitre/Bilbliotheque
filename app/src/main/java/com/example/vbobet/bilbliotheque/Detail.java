package com.example.vbobet.bilbliotheque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import metier.Exemplaire;
import metier.ImportationE;
import metier.ListeExemplairesAdapter;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle b = getIntent().getExtras();
        String livre = b.getString("Livre");
        ImportationE importExemp = new ImportationE();
        importExemp.execute("http://10.0.2.2:3000/android/"+livre);
        ListView listExemplaires = (ListView) findViewById(R.id.listExemplaires);
        try{
            ArrayList<Exemplaire> listExempl = importExemp.get();
            if(listExempl!=null){
                ListeExemplairesAdapter adaptE;
                adaptE = new ListeExemplairesAdapter(getApplicationContext(), listExempl);
                listExemplaires.setAdapter(adaptE);
            }
        } catch (InterruptedException e) {
            Log.i("Parseur", "Interruption lecture fichier"+e.getMessage());
        } catch (ExecutionException e) {
            Log.i("Parseur", "Erreur execution " +e.getMessage());
        }
    }
}
