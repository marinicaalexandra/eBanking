package org.poo.cb.command;

import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class AdaugarePrieten implements Comenzi{

    public static boolean cautaUtilizatorDupaMail(ArrayList<Utilizator> litaUtilizatori, String emailCautat){
        for(Utilizator utilizator : litaUtilizatori)
            if(utilizator.getEmail().contains(emailCautat))
                return true;
        return false;
    }
    @Override
    public void executaComanda(ParametriiComplecsi parametriiComplecsi) {
        ArrayList<Utilizator> utilizatori = parametriiComplecsi.getListaUtilizatori();
        String linie = parametriiComplecsi.getLinie();
        Utilizator utilizatorNou = new Utilizator();
        String s = utilizatorNou.extragereMail(linie);

        if(cautaUtilizatorDupaMail(utilizatori, s) == false)
            System.out.println("User with " + s + " doesn't exist");
        else
        {
            for (Utilizator utilizator : utilizatori) {
                if (utilizator.getEmail().contains(s)) {
                    utilizator.adaugarePrieten2(linie);
                }
            }
        }


        String ss = null;
        int ii = linie.lastIndexOf(' ');
        ss = linie.substring(ii + 1, linie.length());

        if(cautaUtilizatorDupaMail(utilizatori, ss) == false)
            System.out.println("User with " + ss + " doesn't exist");
        else
        {
            for (Utilizator utilizator : utilizatori) {
                if (utilizator.getEmail().contains(ss)) {
                    utilizator.adaugarePrieten1(linie);
                }
            }
        }
    }
}
