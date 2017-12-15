package metier;

/**
 * Created by vbobet on 15/12/2017.
 */

public class Exemplaire {

    private int _unNumero;
    private String _unStatut;
    private String _uneDateRetour;

    public Exemplaire(int unNumero, String unStatut, String uneDateRetour){
        _unNumero = unNumero;
        _unStatut = unStatut;
        _uneDateRetour = uneDateRetour;
    }


    public int get_unNumero() {
        return _unNumero;
    }

    public String get_unStatut() {
        return _unStatut;
    }

    public String get_uneDateRetour() {
        return _uneDateRetour;
    }

}
