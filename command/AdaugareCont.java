package org.poo.cb.command;

import org.poo.cb.Cont;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class AdaugareCont implements Comenzi{
    @Override
    public void executaComanda(ParametriiComplecsi parametriiComplecsi) {
        ArrayList<Utilizator> utilizatori = parametriiComplecsi.getListaUtilizatori();
        String linie = parametriiComplecsi.getLinie();
        Cont contAux = new Cont();
        contAux.adaugareContUtilizator(linie, utilizatori);
    }
}
