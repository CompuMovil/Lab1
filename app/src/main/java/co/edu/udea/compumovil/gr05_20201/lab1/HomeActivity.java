package co.edu.udea.compumovil.gr05_20201.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import co.edu.udea.compumovil.gr05_20201.lab1.data.IComunicationFragments;
import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;

import co.edu.udea.compumovil.gr05_20201.lab1.R;
import co.edu.udea.compumovil.gr05_20201.lab1.POIAdd;
import co.edu.udea.compumovil.gr05_20201.lab1.POIDetail;
import co.edu.udea.compumovil.gr05_20201.lab1.POIList;
import co.edu.udea.compumovil.gr05_20201.lab1.Settings;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, IComunicationFragments {

    private Button btList,btAdd, btSettings;
    private FragmentTransaction transaction;
    private Fragment list, add, details, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list = new POIList();
        add = new POIAdd();
        settings = new Settings();
        btList = findViewById(R.id.ma_bt_list);
        btAdd = findViewById(R.id.ma_bt_add);
        btSettings = findViewById(R.id.ma_bt_settings);

        btList.setOnClickListener(this);
        btAdd.setOnClickListener(this);
        btSettings.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.ma_f_container,list).commit();
    }

    @Override
    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.ma_bt_list:
                transaction.replace(R.id.ma_f_container,list);
                transaction.addToBackStack(null);
                break;
            case R.id.ma_bt_add:
                transaction.replace(R.id.ma_f_container,add);
                transaction.addToBackStack(null);
                break;
            case R.id.ma_bt_settings:
                transaction.replace(R.id.ma_f_container,settings);
                transaction.addToBackStack(null);
                break;
        }
        transaction.commit();

    }

    @Override
    public void sendPOI(POI poi) {
        details = new POIDetail();
        Bundle bundleSender = new Bundle();
        bundleSender.putSerializable("Object",poi);
        details.setArguments(bundleSender);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.ma_f_container,details);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}