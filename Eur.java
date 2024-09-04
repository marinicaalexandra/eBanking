package org.poo.cb;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Eur extends Bani{

    public static class EurBuilder{
        private float gbp, eur, usd, jpy, cad;
        public Eur.EurBuilder setUsd(float usd) {
            this.usd = usd;
            return this;
        }

        public Eur.EurBuilder setGbp(float gbp) {
            this.gbp = gbp;
            return this;
        }

        public Eur.EurBuilder setCad(float cad) {
            this.cad = cad;
            return this;
        }

        public Eur.EurBuilder setJpy(float jpy) {
            this.jpy = jpy;
            return this;
        }

        public Eur.EurBuilder setEur(float eur) {
            this.eur = eur;
            return this;
        }

        public Eur build(){
            return new Eur(gbp, eur, usd, jpy, cad);
        }
    }
    public Eur(float gbp, float eur, float usd, float jpy, float cad){
        this.gbp = gbp;
        this.eur = eur;
        this.jpy = jpy;
        this.cad = cad;
        this.usd = usd;
    }

    @Override
    public void schimbaBani(String tip2, float suma, String email, ArrayList<Utilizator> utilizatori) {
        //System.out.print("mac");

        //trebuie sa schimb suma din euro in tip2
        //1-caut contul care are utilizatorul cu emailul dat
        //2-realizez schimbul de date, actualizant informatiile contului

        //System.out.print(email);

        for(Utilizator uaux : utilizatori)
            if(uaux.getEmail().contains(email))
            {
                //am gasit utilizatorul pt care se realizezaza schimbul
                for (Cont caux : uaux.listaConturiUtilizator)
                    if(caux.tip.contains(tip2))
                    {
                        float sumaExtrasa = 0;
                        if(tip2.contains("EUR"))
                            sumaExtrasa = suma * eur;
                        if(tip2.contains("GBP"))
                            sumaExtrasa = suma * gbp;
                        if(tip2.contains("USD"))
                            sumaExtrasa = suma * usd;
                        if(tip2.contains("CAD"))
                            sumaExtrasa = suma * cad;
                        if(tip2.contains("JPY"))
                            sumaExtrasa = suma * jpy;

                        if(sumaExtrasa > caux.sumaBaniCont)
                            System.out.println("Insufficient amount in account " + tip2 + " for exchange");

                        caux.sumaBaniCont = caux.sumaBaniCont - sumaExtrasa;
                        if(2 * sumaExtrasa > caux.sumaBaniCont)
                        {
                            float comision = sumaExtrasa / 100;
                            caux.sumaBaniCont = caux.sumaBaniCont - comision;
                        }

                        for (Cont cont : uaux.listaConturiUtilizator)
                            if(cont.tip.contains("EUR"))
                                cont.sumaBaniCont = cont.sumaBaniCont + suma;
                    }
            }

    }
}
