package org.poo.cb;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;
import java.math.BigDecimal;

public class Utilizator {
    private String email = null;
    private String firstName = null;
    private String lastName = null;
    private String adresa = null;
    public Utilizator(){}
    public Utilizator(String email, String firstName, String lastName, String adresa)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAdresa(){
        return adresa;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public ArrayList<Cont> listaConturiUtilizator = new ArrayList<>();
    ArrayList<String> listaPrieteni = new ArrayList<>();
    ArrayList<String> stocuriCumparate = new ArrayList<>();
    ArrayList<Integer> cantitateStocuri = new ArrayList<>();
    public String extragereMail(String comanda) {
        String[] cuvinte = comanda.split(" ");
        return cuvinte[2];
    }

    public String extragereMailPortofoliu(String comanda) {
        String[] cuvinte = comanda.split(" ");
        return cuvinte[2];
    }

    public void listeazaPortofoliu(String comanda, ArrayList<Utilizator> listautilizatori){

        String email = extragereMailPortofoliu(comanda);

        for(Utilizator uu : listautilizatori)
            if(uu.email.contains(email))
               {
                   String afisare = null;
                   //afisare = "{\"stocks\":[]" + ",\"accounts\":[";
                   System.out.print("{\"stocks\":[");


                   int a = 0;
                   if(uu.stocuriCumparate.size() > 0)
                   {
                       int index = 0;
                       for (String nume : uu.stocuriCumparate)
                       {
                           if(a>0)
                               System.out.print(",");
                           System.out.print("{\"stockname\":\"" + nume + "\",\"amount\":");
                           for(int j = 0; j < uu.cantitateStocuri.size(); j++)
                               if(j == index)
                                   System.out.print(uu.cantitateStocuri.get(j) + "}");
                           a++;
                           index++;
                       }
                   }

                   System.out.print("],\"accounts\":[");

                   int aa = 0;
                   for (Cont c : uu.listaConturiUtilizator)
                   {
                       if(aa!= 0)
                           System.out.print(",");
                        //afisare = afisare + "{\"currencyName\":\"" + c.tip + "\",\"amount\":\"" + c.sumaBaniCont + "0\"},";
                       System.out.print("{\"currencyName\":\"" + c.tip + "\",\"amount\":\"");

                       String numar = Float.toString(c.sumaBaniCont);
                       int ind = numar.indexOf(".");
                       int nrzecimale = numar.length() - ind - 1;

                       if(nrzecimale > 2)
                       {
                            String str = String.format("%.2f", c.sumaBaniCont);
                            String strr = str.replace(',','.');
                            System.out.print(strr);
                       }
                       else
                            System.out.print(c.sumaBaniCont);

                       if(nrzecimale == 1)
                           System.out.print("0");
                       System.out.print("\"}");
                       aa++;
                   }
                   System.out.println("]}");
                   break;
               }


    }

    public String extragereContUtilizator(String comanda) {
        String[] cuvinte = comanda.split(" ");
        return cuvinte[3];
    }
    public float extragereSumaContUtilizator(String comanda) {
        String[] cuvinte = comanda.split(" ");
        return Float.parseFloat(cuvinte[4]);
    }
    public String extragereFirstName(String comanda) {
        String[] cuvinte = comanda.split(" ");
        return cuvinte[3];
    }

    public String extragereLastName(String comanda) {
        String[] cuvinte = comanda.split(" ");
        return cuvinte[4];
    }

    public String extragereAdresa(String comanda) {
        String[] cuvinte = comanda.split(" ");
        String adresa = cuvinte[5];
        int index = 0;
        for (String cuv : cuvinte)
        {
            if(index > 5)
                adresa = adresa + " " +cuv;
            index++;
        }
        return adresa;
    }
    public void creeareUtilizator(String comanda) {
        email = extragereMail(comanda);
        firstName = extragereFirstName(comanda);
        lastName = extragereLastName(comanda);
        adresa = extragereAdresa(comanda);
    }

    @Override
    public String toString() {

        String afisare = "{\"email\":\"" + email + "\",\"firstname\":\"" + firstName + "\",\"lastname\":\"" + lastName + "\",\"address\":\"" + adresa + "\",\"friends\":[";

        for (String parcurg : listaPrieteni)
            afisare = afisare + "\"" + parcurg + "\"";

        afisare = afisare + "]}";

        return afisare;

    }

    public String extrageMailPrieten1(String comanda){
        String[] cuvinte = comanda.split(" ");
        return cuvinte[2];
    }

    public String extrageMailPrieten2(String comanda){
        String[] cuvinte = comanda.split(" ");
        return cuvinte[3];
    }

    public void adaugarePrieten2(String comanda) {
        String auxiliar = extrageMailPrieten2(comanda);
        boolean OK = false;
        for(String cautPrieten : listaPrieteni)
            if(cautPrieten.contains(auxiliar))
                OK = true;
        if(OK == false)
            listaPrieteni.add(auxiliar);
        else
            System.out.println("User with " + auxiliar + " is already a friend");
    }

    public void adaugarePrieten1(String comanda) {
        String auxiliar = extrageMailPrieten1(comanda);
        boolean OK = false;
        for(String cautPrieten : listaPrieteni)
            if(cautPrieten.contains(auxiliar))
                OK = true;
        if(OK == false)
            listaPrieteni.add(auxiliar);
        else
            System.out.print("User with " + auxiliar + " is already a friend");
    }
}
