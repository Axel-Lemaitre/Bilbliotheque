package metier;

import android.content.Context;
import android.util.Log;
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

public class ListeExemplairesAdapter extends BaseAdapter{

    private List<Exemplaire> listeExemplaires;
    private LayoutInflater inflater;

    public ListeExemplairesAdapter(Context context, List<Exemplaire> listeL) {
        this.inflater=LayoutInflater.from(context);
        this.listeExemplaires=listeL;
    }

    @Override
    public int getCount() {
        return this.listeExemplaires.size();
    }

    @Override
    public Exemplaire getItem(int i) {
        return this.listeExemplaires.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView numero;
        TextView statut;
        TextView date;
        if (convertView==null){
            convertView = this.inflater.inflate(R.layout.vue_exemplaire,parent,false);
            numero = convertView.findViewById(R.id.txtNumero);
            statut = convertView.findViewById(R.id.txtStatut);
            date = convertView.findViewById(R.id.txtDate);
            convertView.setTag(R.id.txtNumero,numero);
            convertView.setTag(R.id.txtStatut,statut);
            convertView.setTag(R.id.txtDate,date);
        }
        else{
            numero = (TextView) convertView.getTag(R.id.txtNumero);
            statut = (TextView) convertView.getTag(R.id.txtStatut);
            date = (TextView) convertView.getTag(R.id.txtDate);
        }
        Exemplaire exmp = this.getItem(position);
        numero.setText(exmp.get_unNumero());
        statut.setText(exmp.get_unStatut());
        date.setText(exmp.get_uneDateRetour());
        return convertView;
    }
}