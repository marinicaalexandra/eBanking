package org.poo.cb.command;

import org.poo.cb.Actiuni;
import org.poo.cb.Utilizator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecomandaStocuri implements Comenzi{
    @Override
    public void executaComanda(ParametriiComplecsi parametriiComplecsi) {

        String fileStocks = parametriiComplecsi.fileStocks;
        Actiuni actiune = new Actiuni();
        Map<String, String[]> hashMapp = new HashMap<>();
        hashMapp = actiune.citesteStocksValue(fileStocks);
        actiune.recomandareStocuri(hashMapp);
    }
}
