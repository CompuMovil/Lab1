package co.edu.udea.compumovil.gr05_20201.lab1.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import co.edu.udea.compumovil.gr05_20201.lab1.model.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDAO getUserDao();

}