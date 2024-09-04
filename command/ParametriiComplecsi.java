package org.poo.cb.command;

import org.poo.cb.Bani;
import org.poo.cb.Factory;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class ParametriiComplecsi {
    String fileStocks = null;
    String linie = null;
    ArrayList<Utilizator> listaUtilizatori = new ArrayList<>();
    Factory factory = Factory.getInstantaFactory();
    Bani baniEurr = new Bani(), baniGbpp = new Bani(), baniJpyy = new Bani(), baniCadd = new Bani(), baniUsdd = new Bani();
    public ParametriiComplecsi(String linie, ArrayList<Utilizator> utilizatori)
    {
        this.linie = linie;
        this.listaUtilizatori = utilizatori;
    }
    public Bani getBaniEurr(){return baniEurr;}
    public void setBaniEurr(Bani ban){this.baniEurr = ban;}
    public Bani getBaniGbpp(){return baniGbpp;}
    public void setBaniGbpp(Bani ban){this.baniGbpp = ban;}
    public Bani getBaniJpyy(){return baniJpyy;}
    public void setBaniJpyy(Bani ban){this.baniJpyy = ban;}
    public Bani getBaniCadd(){return baniCadd;}
    public void setBaniCadd(Bani ban){this.baniCadd = ban;}
    public Bani getBaniUsdd(){return baniUsdd;}
    public void setBaniUsdd(Bani ban){this.baniUsdd = ban;}
    public Factory getFactory(){return  factory;}
    public void setFactory(Factory factory1){this.factory = factory1;}
    public String getLinie()
    {
        return linie;
    }
    public void setLinie(String linie)
    {
        this.linie = linie;
    }

    public String getFileStocks()
    {
        return fileStocks;
    }
    public void setFileStocks(String fileStocks)
    {
        this.fileStocks = fileStocks;
    }
    public ArrayList<Utilizator> getListaUtilizatori()
    {
        return listaUtilizatori;
    }

    public void setListaUtilizatori(ArrayList<Utilizator> utilizatori)
    {
        this.listaUtilizatori = utilizatori;
    }
}
