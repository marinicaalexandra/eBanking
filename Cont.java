package org.poo.cb;

import java.util.ArrayList;
import java.util.TreeMap;

public class Cont {
    public String tip;
    public float sumaBaniCont;
    public Cont(){}
    public Cont(String tip, float sumaBaniCont)
    {
        this.tip = tip;
        this.sumaBaniCont = sumaBaniCont;
    }
    public void adaugaBani(float sumaBaniSupliment)
    {
        sumaBaniCont = sumaBaniCont + sumaBaniSupliment;
    }

    public void adaugareContUtilizator(String comanda, ArrayList<Utilizator> lista) {
        Utilizator utilizatorContAdaugare = new Utilizator();
        String emailUtilizator = utilizatorContAdaugare.extragereMail(comanda);

        String numeCont = utilizatorContAdaugare.extragereContUtilizator(comanda);
        Cont c = new Cont(numeCont, 0);
        for (Utilizator uaux : lista)
            if(uaux.getEmail().contains(emailUtilizator))
                uaux.listaConturiUtilizator.add(c);
    }

    public void adaugareBaniContUtilizator(String comanda, ArrayList<Utilizator> lista){
        //1-verific daca exista contul respectiv pt acel utilizator
        //2-extrag email, cobnt si suma de bani
        //3-maresc arraylistul de conturi

        Utilizator utilizatorContAdaugare = new Utilizator();

        String email = utilizatorContAdaugare.extragereMail(comanda);
        String cont = utilizatorContAdaugare.extragereContUtilizator(comanda);
        float suma = utilizatorContAdaugare.extragereSumaContUtilizator(comanda);
        Cont contNou = new Cont(cont, suma);
        for (Utilizator uaux : lista)
            if(uaux.getEmail().contains(email))
            {
                //uaux.listaConturiUtilizator.add(contNou);
                for (Cont cauta : uaux.listaConturiUtilizator)
                    if(cauta.tip.contains(cont))
                        cauta.adaugaBani(suma);
            }
    }

    public void transferaBani(String comanda, ArrayList<Utilizator> utilizatori)
    {
        String[] cuvinte = comanda.split(" ");
        String emailDator = cuvinte[2];
        String emailPrimeste = cuvinte[3];
        String tipBani = cuvinte[4];
        String suma = cuvinte[5];
        float datorie = Float.parseFloat(suma);
        //System.out.println(emailDator + emailPrimeste + " " + tipBani + " " + suma);

        //verific daca emailDator si emailPrimeste sunt prieteni
        boolean OK = false;
        for (Utilizator util : utilizatori)
            if(util.getEmail().contains(emailDator))
            {
                for(String prieten : util.listaPrieteni)
                    if(prieten.contains(emailPrimeste))
                        OK = true;
            }
        if(OK == false)
            System.out.println("You are not allowed to transfer money to" + emailPrimeste);

        for(Utilizator util : utilizatori) {

            if (util.getEmail().contains(emailDator)) {
                for (Cont cont : util.listaConturiUtilizator)
                    if (cont.tip.contains(tipBani)) {
                        if(datorie > cont.sumaBaniCont)
                            System.out.println("Insufficient amount in account " + tipBani + " for transfer");

                        cont.sumaBaniCont = cont.sumaBaniCont - datorie;
                    }
            } else if (util.getEmail().contains(emailPrimeste)) {
                for (Cont cont : util.listaConturiUtilizator)
                    if (cont.tip.contains(tipBani))
                        cont.sumaBaniCont = cont.sumaBaniCont + datorie;
            }
        }
    }

}
