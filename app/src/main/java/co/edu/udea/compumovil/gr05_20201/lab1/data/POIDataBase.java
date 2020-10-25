package co.edu.udea.compumovil.gr05_20201.lab1.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
<<<<<<< HEAD
import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;

@Database(entities = {POI.class}, version = 1, exportSchema = false)

public abstract class POIDataBase  extends  RoomDatabase {
    public abstract POIDAO poiDAO();
}
=======

import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;


@Database(entities = {POI.class}, version = 1, exportSchema = false)
public abstract class POIDataBase extends RoomDatabase {
    public abstract POIDAO getPOIDAO();
}
>>>>>>> e8b3c1ec0f10e2cf93c6f21c0ebdb804ac64a1c9
