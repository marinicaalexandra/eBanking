package org.poo.cb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

public class Actiuni {

    public Map<String, String[]> hashMap = new HashMap<>();
    public Map citesteStocksValue(String file)
    {

        int numerLinieFisierCsv = 0;
        try (BufferedReader citire = new BufferedReader(new FileReader(file))) {
            String linie;

            while ((linie = citire.readLine()) != null) {
                if(numerLinieFisierCsv > 0)
                {
                    String numeActiune = null;
                    String[] vectoriValActiune = new String[11];
                    int indiceVector = -1;

                    String delimitator = ",";
                    String[] cuvinte = linie.split(delimitator);
                    int numarCuv = 0;
                    for (String cuvant : cuvinte)
                    {
                        if(numarCuv == 0)
                            numeActiune = cuvant;
                        else
                        {
                            indiceVector++;
                            vectoriValActiune[indiceVector] = cuvant;
                        }
                        numarCuv++;
                    }
                    hashMap.put(numeActiune, vectoriValActiune);

                }
                numerLinieFisierCsv++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;

    }

    public void recomandareStocuri(Map<String, String[]> hashMap)
    {
        System.out.print("{\"stocksToBuy\":[");

        int indexAfisare = 0;
        float suma10 = 0, suma5 = 0;
        for (String[] valori : hashMap.values()) {
            suma10 = 0;
            suma5 = 0;
            int index = 0;
            for (String valoare : valori) {
                float nr = 0;
                if(valoare != null)
                    nr = Float.parseFloat(valoare);

                suma10 = suma10 + nr;
                if(index > 4)
                    suma5 = suma5 + nr;
                index++;
            }
            if(suma5/5 > suma10/10)
            {

                for (String cheie : hashMap.keySet()) {
                    if (hashMap.get(cheie).equals(valori)) {
                        if(indexAfisare > 0)
                            System.out.print(",");
                        System.out.print("\"" + cheie + "\"");
                        indexAfisare++;
                        break;
                    }
                }
            }
        }
        System.out.println("]}");

    }

    public void cumparaStocuri(String linie, ArrayList<Utilizator> utilizatori, Map<String, String[]> hashMap)
    {
        String[] cuvinte = linie.split(" ");
        String emailCumparator = cuvinte[2];
        String actiune = cuvinte[3];
        String suma = cuvinte[4];
        //System.out.print(emailCumparator + " " + actiune + " " + suma);

        for (Utilizator utilizator : utilizatori)
        {
            if(utilizator.getEmail().contains(emailCumparator))
            {
                for (Cont cont : utilizator.listaConturiUtilizator)
                    if(cont.tip.contains("USD"))
                        for (String cheie : hashMap.keySet()) {
                            if (cheie.equals(actiune)) {
                                String[] valori = hashMap.get(cheie);

                                float stock = Float.parseFloat(valori[9]);
                                int sumaa = Integer.parseInt(suma);
                                if(cont.sumaBaniCont < sumaa * stock)
                                    System.out.println("Insufficient amount in account for buying stock");
                                else
                                    cont.sumaBaniCont = cont.sumaBaniCont - sumaa * stock;

                                utilizator.stocuriCumparate.add(actiune);
                                utilizator.cantitateStocuri.add(sumaa);
                            }
                        }
            }
        }

    }

}
