package co.edu.udea.compumovil.gr05_20201.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.udea.compumovil.gr05_20201.lab1.data.POIDAO;
import co.edu.udea.compumovil.gr05_20201.lab1.data.POIDataBase;
import co.edu.udea.compumovil.gr05_20201.lab1.data.UserDAO;
import co.edu.udea.compumovil.gr05_20201.lab1.data.UserDataBase;
import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;
import co.edu.udea.compumovil.gr05_20201.lab1.model.User;

public class activity_add_DAO extends  {


    EditText editTextPOIName, editTextPOIInformation, editTextPOITemperature, editTextPOIRecomendation, editTextPOIImage
            , editTextPOIAddress, editTextPOICurrency, editTextPOICity, editTextPOICountry, editTextPOIDescription, editTextPOIScore;
    Button buttonAddPOI;

    private POIDAO poiDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__d_a_o);

        editTextPOIName = findViewById(R.id.editTextPOIName);
        editTextPOIInformation = findViewById(R.id.editTextPOIInformation);
        editTextPOITemperature = findViewById(R.id.editTextPOITemperature);
        editTextPOIRecomendation = findViewById(R.id.editTextPOIRecomendation);
        editTextPOIImage = findViewById(R.id.editTextPOIImage);
        editTextPOIAddress = findViewById(R.id.editTextPOIAddress);
        editTextPOICurrency = findViewById(R.id.editTextPOICurrency);
        editTextPOICity = findViewById(R.id.editTextPOICity);
        editTextPOICountry = findViewById(R.id.editTextPOICountry);
        editTextPOIDescription = findViewById(R.id.editTextPOIDescription);
        editTextPOIScore = findViewById(R.id.editTextPOIScore);
        buttonAddPOI = findViewById(R.id.buttonAddPOI);

        poiDAO = Room.databaseBuilder(this, POIDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getPOIDAO();

        buttonAddPOI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String POIName = editTextPOIName.getText().toString().trim();
                String POIInformation = editTextPOIInformation.getText().toString().trim();
                String POITemperature = editTextPOITemperature.getText().toString().trim();
                String POIRecomendation = editTextPOIRecomendation.getText().toString().trim();
                String POIImage = editTextPOIImage.getText().toString().trim();
                String POIAddress = editTextPOIAddress.getText().toString().trim();
                String POICurrency = editTextPOICurrency.getText().toString().trim();
                String POICity = editTextPOICity.getText().toString().trim();
                String POICountry = editTextPOICountry.getText().toString().trim();
                String POIDescription = editTextPOIDescription.getText().toString().trim();
                String POIScore = editTextPOIScore.getText().toString().trim();


                    POI poi = new POI(String POIName, String POIInformation, String POITemperature, POIRecomendation, POIImage, POIAddress, POICurrency,
                            POICity, POICountry, POIDescription, POIScore);
                    poiDAO.insert(poi);

                    Intent moveToPpal = new Intent(activity_add_DAO.this, HomeActivity.class);
                    startActivity(moveToPpal);


                    Toast.makeText(activity_add_DAO.this, "Place Saved", Toast.LENGTH_SHORT).show();


            }
        });
    }
}