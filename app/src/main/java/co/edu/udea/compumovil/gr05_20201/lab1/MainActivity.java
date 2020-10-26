package co.edu.udea.compumovil.gr05_20201.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import co.edu.udea.compumovil.gr05_20201.lab1.data.UserDAO;
import co.edu.udea.compumovil.gr05_20201.lab1.data.UserDataBase;
import co.edu.udea.compumovil.gr05_20201.lab1.model.User;


public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDAO db;
    UserDataBase dataBase;
    //POIDAO db2;  --para quemar los datos en la bd--

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();
        /* _-----Intentando quemar los datos en la base de datos ----
        db2 = Room.databaseBuilder(this, POIDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build().poiDAO();*/

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                User user = db.getUser(email, password);

                if (user != null) {
                    /* _-----Intentando quemar los datos en la base de datos ----

                    POI poi1 = new POI("Udea", "En Medellin", "32", "Path", "crr51 43", "5", "disfrutad");
                    POI poi2 = new POI("Ruta N", "En Medellin", "32", "Path", "crr 43 a", "5", "trabajar");
                    POI poi3 = new POI("Parque de los Deseos", "En Medellin", "32", "Path", "crra 43", "3", "cuidado");
                    POI poi4 = new POI("Parque Luces", "EN medellin", "32", "Path", "cl 67", "2", "cuidado");
                    POI poi5 = new POI("Unal", "EN medellin", "32", "Path", "cl 53", "4", "POr ahi");

                    db2.insert(poi1);
                    db2.insert(poi2);
                    db2.insert(poi3);
                    db2.insert(poi4);
                    db2.insert(poi5);*/

                    Intent i = new Intent(MainActivity.this, HomeActivity.class);

                    i.putExtra("User", user);
                    startActivity(i);

                    finish();

                }else{
                    Toast.makeText(MainActivity.this, "Unregistered user or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
