package org.poo.cb.command;

import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class ListareUtilizator implements Comenzi{
    @Override
    public void executaComanda(ParametriiComplecsi parametriiComplecsi) {
        ArrayList<Utilizator> utilizatori = parametriiComplecsi.getListaUtilizatori();
        String linie = parametriiComplecsi.getLinie();
        String util = linie.substring(10, linie.length());
        boolean gasit = false;
        for(Utilizator utilizator : utilizatori)
            if(utilizator.getEmail().contains(util))
            {
                System.out.println(utilizator);
                gasit = true;
            }
        if(gasit == false)
            System.out.println("User with john.doe@email.com doesn't exist");
    }
}
