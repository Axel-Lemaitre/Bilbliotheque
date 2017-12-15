package metier;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vbobet on 01/12/2017.
 */

public class ImportationE extends AsyncTask<String, Void, ArrayList<Exemplaire>>{

    @Override
    protected ArrayList<Exemplaire> doInBackground(String... urls) {
        URL url;
        String ligne;
        try{
            ArrayList<Exemplaire> listeImportee;
            url = new URL(String.valueOf(urls[0]));
            InputStream is = url.openConnection().getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader buff = new BufferedReader(isr);
            ligne = buff.readLine();
            Log.i("Objet","lignge : "+ligne);
            Gson gson = new Gson();
            listeImportee = gson.fromJson(ligne,
                    new TypeToken<ArrayList<Exemplaire>>(){}.getType());
            Log.i("Objet","listImport : "+listeImportee.get(0));
            return listeImportee;
        } catch (MalformedURLException e){
            Log.i("Parseur", "URL incorrecte "+e.getMessage());
            return null;
        } catch (IOException e){
            Log.i("Parseur", "Problème I/O " + e.getMessage());
            return null;
        }
    }
}