package com.liceu.geom.DAO;

import com.liceu.geom.model.Figura;

import java.util.ArrayList;
import java.util.List;

public class FiguraDAOImpl implements FiguraDAO{

    static List<Figura> figuraList = new ArrayList<>();
    static List<Figura> meFiguraList = new ArrayList<>();


    @Override
    public void save(Figura m) {
        figuraList.add(m);
    }

    public void saveMe (Figura m) {
        meFiguraList.add(m);
    }

    @Override
    public List<Figura> getAllFiguras() {
        return figuraList;
    }

    @Override
    public List<Figura> getAllMeFiguras() {
        return meFiguraList;
    }

    public void deleteFiguras(Figura figura){
        figuraList.remove(figura);

    }
}
