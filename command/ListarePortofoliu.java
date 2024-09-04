package org.poo.cb.command;

import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class ListarePortofoliu implements Comenzi{
    @Override
    public void executaComanda(ParametriiComplecsi parametriiComplecsi) {
        ArrayList<Utilizator> utilizatori = parametriiComplecsi.getListaUtilizatori();
        String linie = parametriiComplecsi.getLinie();
        Utilizator utilizatorNou = new Utilizator();
        utilizatorNou.listeazaPortofoliu(linie, utilizatori);
    }
}
