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

public class Importation extends AsyncTask<String, Void, ArrayList<Livre>>{

    @Override
    protected ArrayList<Livre> doInBackground(String... urls) {
        URL url;
        String ligne;
        try{
            ArrayList<Livre> listeImportee;
            url = new URL(String.valueOf(urls[0]));
            InputStream is = url.openConnection().getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader buff = new BufferedReader(isr);
            ligne = buff.readLine();
            Gson gson = new Gson();
            listeImportee = gson.fromJson(ligne,
                    new TypeToken<ArrayList<Livre>>(){}.getType());
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
