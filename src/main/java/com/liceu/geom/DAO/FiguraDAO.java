package com.liceu.geom.DAO;

import com.liceu.geom.model.Figura;
import com.liceu.geom.model.Message;

import java.util.List;

public interface FiguraDAO {

    void save (Figura m);
    void saveMe (Figura m);
    List<Figura> getAllFiguras();
    List<Figura> getAllMeFiguras();
    public void deleteFiguras(Figura figura);

}
