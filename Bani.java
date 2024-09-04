package org.poo.cb;

import org.poo.cb.command.ParametriiComplecsi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bani {
    float eur, gbp, jpy, usd, cad;
    public void schimbaBani(String tip2, float suma, String email, ArrayList<Utilizator> utilizatori){};
    public void extragegeValoriBani(ParametriiComplecsi paramComplecsi){
        Factory factory = Factory.getInstantaFactory();

        int numarLinii = 0;
        Bani baniEur = null, baniGbp = null, baniJpy = null, baniCad = null, baniUsd = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/common/exchangeRates.csv"))) {
            String linie;

            while ((linie = bufferedReader.readLine()) != null) {
                if(numarLinii > 0)
                {
                    String[] valori = linie.split(",");

                    float schimbEur = Float.parseFloat(valori[1]);
                    float schimbGbp = Float.parseFloat(valori[2]);
                    float schimbJpy = Float.parseFloat(valori[3]);
                    float schimbCad = Float.parseFloat(valori[4]);
                    float schimbUsd = Float.parseFloat(valori[5]);

                    Bani bani = factory.creeazaFactoryBani(valori[0], schimbEur, schimbGbp, schimbJpy, schimbCad, schimbUsd);

                    if(numarLinii == 1)
                        baniEur = bani;
                    if(numarLinii == 2)
                        baniGbp = bani;
                    if(numarLinii == 3)
                        baniJpy = bani;
                    if(numarLinii == 4)
                        baniCad = bani;
                    if(numarLinii == 5)
                        baniUsd = bani;
                }
                numarLinii++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        paramComplecsi.setFactory(factory);
        paramComplecsi.setBaniEurr(baniEur);
        paramComplecsi.setBaniGbpp(baniGbp);
        paramComplecsi.setBaniCadd(baniCad);
        paramComplecsi.setBaniJpyy(baniJpy);
        paramComplecsi.setBaniUsdd(baniUsd);

    }
}
