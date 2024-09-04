package org.poo.cb;

import java.util.ArrayList;

public class Gbp extends Bani{

    public static class GbpBuilder{
        private float gbp, eur, usd, jpy, cad;
        public GbpBuilder setUsd(float usd) {
            this.usd = usd;
            return this;
        }

        public GbpBuilder setGbp(float gbp) {
            this.gbp = gbp;
            return this;
        }

        public GbpBuilder setCad(float cad) {
            this.cad = cad;
            return this;
        }

        public GbpBuilder setJpy(float jpy) {
            this.jpy = jpy;
            return this;
        }

        public GbpBuilder setEur(float eur) {
            this.eur = eur;
            return this;
        }

        public Gbp build(){
            return new Gbp(gbp, eur, usd, jpy, cad);
        }
    }
    public Gbp(float gbp, float eur, float usd, float jpy, float cad){
        this.gbp = gbp;
        this.eur = eur;
        this.jpy = jpy;
        this.cad = cad;
        this.usd = usd;
    }

    @Override
    public void schimbaBani(String tip2, float suma, String email, ArrayList<Utilizator> utilizatori) {
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
                            if(cont.tip.contains("GBP"))
                                cont.sumaBaniCont = cont.sumaBaniCont + suma;
                    }
            }
    }
}
