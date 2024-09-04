package org.poo.cb.command;

import org.poo.cb.Utilizator;

import java.util.List;
import java.util.ArrayList;

public class SetterComenzi {
    private List<Comenzi> comenzi = new ArrayList<>();
    public void adaugaComanda(Comenzi comanda) {
        comenzi.add(comanda);
    }
    public void executaToateComenzile(ParametriiComplecsi parametriiComplecsi) {
        for (Comenzi comanda : comenzi) {
            comanda.executaComanda(parametriiComplecsi);
        }
        comenzi.clear();
    }
}
