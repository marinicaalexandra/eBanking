package org.poo.cb.command;

import org.poo.cb.Bani;
import org.poo.cb.Factory;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class SchimbaBani implements Comenzi{
    @Override
    public void executaComanda(ParametriiComplecsi parametriiComplecsi) {

        ArrayList<Utilizator> utilizatori = parametriiComplecsi.getListaUtilizatori();
        String linie = parametriiComplecsi.getLinie();
        Factory factory = parametriiComplecsi.getFactory();
        Bani baniEur = parametriiComplecsi.getBaniEurr();
        Bani baniGbp = parametriiComplecsi.getBaniGbpp();
        Bani baniJpy = parametriiComplecsi.getBaniJpyy();
        Bani baniCad = parametriiComplecsi.getBaniCadd();
        Bani baniUsd = parametriiComplecsi.getBaniUsdd();

        String[] cuvinte = linie.split(" ");
        String email = cuvinte[2];
        String tip2 = cuvinte[3];
        String tip1 = cuvinte[4];
        String sumas = cuvinte[5];
        float suma = Float.parseFloat(sumas);

        factory.schimbaBani(tip1, tip2, suma, baniEur, baniGbp, baniUsd, baniJpy, baniCad, email, utilizatori);
    }
}
