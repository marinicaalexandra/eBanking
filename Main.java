package org.poo.cb;

import org.poo.cb.command.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        if(args == null) {
            System.out.println("Running Main");
            return;
        }

        ArrayList<Utilizator> utilizatori = new ArrayList<>();
        ParametriiComplecsi paramComplecsi = new ParametriiComplecsi(null, utilizatori);

        Bani banii = new Bani();
        banii.extragegeValoriBani(paramComplecsi);

        String numeTest = args[1].substring(0,6);
        String fileCommands = "src/main/resources/" + numeTest + "commands.txt";
        String fileStocks = "src/main/resources/" + numeTest + "stockValues.csv";

        Actiuni a = new Actiuni();
        a.citesteStocksValue(fileStocks);

        SetterComenzi listaComenzi = new SetterComenzi();

        paramComplecsi.setFileStocks(fileStocks);

        try (BufferedReader br = new BufferedReader(new FileReader(fileCommands))) {
            String linie;

            while ((linie = br.readLine()) != null) {

                paramComplecsi.setListaUtilizatori(utilizatori);
                paramComplecsi.setLinie(linie);

                if(linie.contains("CREATE USER"))
                {
                    Comenzi creeareUtilizator = new UtilizatorNou();
                    listaComenzi.adaugaComanda(creeareUtilizator);
                    listaComenzi.executaToateComenzile(paramComplecsi);

                }
                if(linie.contains("ADD FRIEND")) {
                    Comenzi adaugarePrieten = new AdaugarePrieten();
                    listaComenzi.adaugaComanda(adaugarePrieten);
                    listaComenzi.executaToateComenzile(paramComplecsi);

                }
                if(linie.contains("LIST USER")){
                    Comenzi listareUtilizator = new ListareUtilizator();
                    listaComenzi.adaugaComanda(listareUtilizator);
                    listaComenzi.executaToateComenzile(paramComplecsi);

                }
                if(linie.contains("ADD ACCOUNT")){
                    Comenzi adaugareCont = new AdaugareCont();
                    listaComenzi.adaugaComanda(adaugareCont);
                    listaComenzi.executaToateComenzile(paramComplecsi);
                }
                if(linie.contains("ADD MONEY")){
                    Comenzi adaugareBani = new AdaugareBani();
                    listaComenzi.adaugaComanda(adaugareBani);
                    listaComenzi.executaToateComenzile(paramComplecsi);
                }
                if(linie.contains("LIST PORTFOLIO")){
                    Comenzi listarePortofoliu = new ListarePortofoliu();
                    listaComenzi.adaugaComanda(listarePortofoliu);
                    listaComenzi.executaToateComenzile(paramComplecsi);
                }
                if(linie.contains("EXCHANGE MONEY")){
                    Comenzi schimbaBani = new SchimbaBani();
                    listaComenzi.adaugaComanda(schimbaBani);
                    listaComenzi.executaToateComenzile(paramComplecsi);
                }
                if(linie.contains("TRANSFER MONEY"))
                {
                    Comenzi transferaBani = new TransferaBani();
                    listaComenzi.adaugaComanda(transferaBani);
                    listaComenzi.executaToateComenzile(paramComplecsi);

                }
                if(linie.contains("RECOMMEND STOCKS"))
                {
                    Comenzi recomandare = new RecomandaStocuri();
                    listaComenzi.adaugaComanda(recomandare);
                    listaComenzi.executaToateComenzile(paramComplecsi);

                }
                if(linie.contains("BUY STOCKS"))
                {
                    Comenzi cumaparaActiuni = new CumparaActiuni();
                    listaComenzi.adaugaComanda(cumaparaActiuni);
                    listaComenzi.executaToateComenzile(paramComplecsi);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}