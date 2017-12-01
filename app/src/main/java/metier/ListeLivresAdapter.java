package metier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vbobet.bilbliotheque.R;

import java.util.List;


/**
 * Created by vbobet on 01/12/2017.
 */

public class ListeLivresAdapter extends BaseAdapter{

    private List<Livre> listeLivres;
    private LayoutInflater inflater;

    public ListeLivresAdapter(Context context, List<Livre> listeL) {
        this.inflater=LayoutInflater.from(context);
        this.listeLivres=listeL;
    }

    @Override
    public int getCount() {
        return this.listeLivres.size();
    }

    @Override
    public Livre getItem(int i) {
        return this.listeLivres.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView titre;
        TextView auteur;
        if (convertView==null){
            convertView = this.inflater.inflate(R.layout.vue_livre,parent,false);
            titre = convertView.findViewById(R.id.txtTitre);
            auteur = convertView.findViewById(R.id.txtAuteur);
            convertView.setTag(R.id.txtTitre,titre);
            convertView.setTag(R.id.txtAuteur,auteur);
        }
        else{
            titre = (TextView) convertView.getTag(R.id.txtTitre);
            auteur = (TextView) convertView.getTag(R.id.txtAuteur);
        }
        Livre livre = this.getItem(position);
        titre.setText(livre.getTitre());
        auteur.setText(livre.getlAuteur().getNom());
        return convertView;
    }
}
