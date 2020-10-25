package co.edu.udea.compumovil.gr05_20201.lab1.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;

@Dao
public interface POIDAO {
    @Query("SELECT * FROM POI")
    List<POI> getAll();

    @Insert
    Long insert(POI poi);
}