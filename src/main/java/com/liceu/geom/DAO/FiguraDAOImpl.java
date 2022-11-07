package com.liceu.geom.DAO;

import com.liceu.geom.model.Figura;

import java.util.ArrayList;
import java.util.List;

public class FiguraDAOImpl implements FiguraDAO{

    static List<Figura> figuraList = new ArrayList<>();



    @Override
    public void save(Figura m) {
        figuraList.add(m);
    }



    @Override
    public List<Figura> getAllFiguras() {
        return figuraList;
    }



    public void deleteFiguras(Figura figura){
        figuraList.remove(figura);

    }
}
