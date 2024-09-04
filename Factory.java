package org.poo.cb;

import java.util.ArrayList;

public class Factory {

    //public Factory(){}
    public static  Factory instantaFactory = null;
    private Factory(){}
    public static Factory getInstantaFactory(){
        if(instantaFactory == null)
            instantaFactory = new Factory();
        return instantaFactory;
    }
    public Bani creeazaFactoryBani(String numeBan, float eur, float gbp, float jpy, float cad, float usd) {
        switch (numeBan) {
            case "EUR":
                return new Eur.EurBuilder()
                        .setGbp(gbp)
                        .setEur(eur)
                        .setUsd(usd)
                        .setJpy(jpy)
                        .setCad(cad)
                        .build();
                //return new Eur(gbp, eur, usd, jpy, cad);
            case "GBP" :
                return new Gbp.GbpBuilder()
                        .setGbp(gbp)
                        .setEur(eur)
                        .setUsd(usd)
                        .setJpy(jpy)
                        .setCad(cad)
                        .build();
                //return new Gbp(gbp, eur, usd, jpy, cad);
            case "USD" :
                return new Usd.UsdBuilder()
                        .setGbp(gbp)
                        .setEur(eur)
                        .setUsd(usd)
                        .setJpy(jpy)
                        .setCad(cad)
                        .build();
                //return new Usd(gbp, eur, usd, jpy, cad);
            case "JPY" :
                return new Jpy.JpyBuilder()
                        .setGbp(gbp)
                        .setEur(eur)
                        .setUsd(usd)
                        .setJpy(jpy)
                        .setCad(cad)
                        .build();
                //return new Jpy(gbp, eur, usd, jpy, cad);
            case "CAD" :
                return new Cad.CadBuilder()
                        .setGbp(gbp)
                        .setEur(eur)
                        .setUsd(usd)
                        .setJpy(jpy)
                        .setCad(cad)
                        .build();
                //return new Cad(gbp, eur, usd, jpy, cad);
            default:
                throw new IllegalArgumentException("Invalid");
        }
    }

    public void schimbaBani(String numeBan1, String numeBan2, float suma, Bani baniEur, Bani baniGbp, Bani baniUsd, Bani baniJpy, Bani baniCad, String email, ArrayList<Utilizator> utilizatori){

        if(numeBan1.contains("EUR"))
            baniEur.schimbaBani(numeBan2, suma, email, utilizatori);
        if(numeBan1.contains("GBP"))
            baniGbp.schimbaBani(numeBan2, suma, email, utilizatori);
        if(numeBan1.contains("USD"))
            baniUsd.schimbaBani(numeBan2, suma, email, utilizatori);
        if(numeBan1.contains("JPY"))
            baniJpy.schimbaBani(numeBan2, suma, email, utilizatori);
        if(numeBan1.contains("CAD"))
            baniCad.schimbaBani(numeBan2, suma, email, utilizatori);
    }

}
