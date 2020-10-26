package co.edu.udea.compumovil.gr05_20201.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import co.edu.udea.compumovil.gr05_20201.lab1.data.IComunicationFragments;
import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, IComunicationFragments {

    private Button btList;
    private FragmentTransaction transaction;
    private Fragment list, add, details, settings;
    private FloatingActionButton icAdd, icSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list = new POIList();
        add = new POIAdd();
        settings = new Settings();
        btList = findViewById(R.id.home_bt_list);
        icAdd = findViewById(R.id.home_ic_add);
        icSettings = findViewById(R.id.home_bt_settings);

        btList.setOnClickListener(this);
        icAdd.setOnClickListener(this);
        icSettings.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.ma_f_container,list).commit();
    }

    @Override
    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.home_bt_list:
                transaction.replace(R.id.ma_f_container,list);
                transaction.addToBackStack(null);
                break;
            case R.id.home_ic_add:
                transaction.replace(R.id.ma_f_container,add);
                transaction.addToBackStack(null);
                break;
            case R.id.home_bt_settings:
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