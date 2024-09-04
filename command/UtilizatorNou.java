package org.poo.cb.command;

import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class UtilizatorNou implements Comenzi{
    @Override
    public void executaComanda(ParametriiComplecsi parametriiComplecsi) {

        ArrayList<Utilizator> utilizatori = parametriiComplecsi.getListaUtilizatori();
        String linie = parametriiComplecsi.getLinie();

        Utilizator u = new Utilizator();
        u.setEmail(u.extragereMail(linie));

        for (Utilizator uAux : utilizatori)
            if(uAux.getEmail().contains(u.getEmail()))
                System.out.println("User with " + uAux.getEmail() + " already exists");

        u.setFirstName(u.extragereFirstName(linie));
        u.setLastName(u.extragereLastName(linie));
        u.setAdresa(u.extragereAdresa(linie));
        utilizatori.add(u);
    }
}
