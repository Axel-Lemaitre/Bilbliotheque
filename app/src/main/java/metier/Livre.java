package metier;

/**
 * Created by vbobet on 01/12/2017.
 */

public class Livre {


    private String _titre;
    private String _resume;
    private String _ISBN;
    private String _auteur;

    public Livre(String unTitre, String unResume, String unIsbn,String unAuteur){
        _titre = unTitre;
        _resume = unResume;
        _ISBN = unIsbn;
        _auteur = unAuteur;
    }


    public String getTitre() {
        return _titre;
    }

    public String getResume() {
        return _resume;
    }

    public String getlAuteur() {
        return _auteur;
    }

    public String getISBN() {
        return _ISBN;
    }


}
