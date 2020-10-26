package co.edu.udea.compumovil.gr05_20201.lab1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import java.io.File;

import co.edu.udea.compumovil.gr05_20201.lab1.data.POIDataBase;
import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link POIAdd#newInstance} factory method to
 * create an instance of this fragment.
 */
public class POIAdd extends Fragment implements View.OnClickListener {

    private Button selectImage,addplace;
    private TextView imagePath;
    private EditText placename,placeinfo,placetemp,placerecomend,placescore, placeaddress;
    View vista;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public POIAdd() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment POIDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static POIAdd newInstance(String param1, String param2) {
        POIAdd fragment = new POIAdd();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.add_poi, container, false);
        addplace = vista.findViewById(R.id.fpa_bt_add);
        imagePath = vista.findViewById(R.id.fpa_tv_image);
        selectImage = vista.findViewById(R.id.fpa_bt_image);
        placename = vista.findViewById(R.id.fpa_et_name);
        placeinfo = vista.findViewById(R.id.fpa_et_information);
        placetemp = vista.findViewById(R.id.fpa_et_temperature);
        placerecomend = vista.findViewById(R.id.fpa_et_recomendation);
        placeaddress = vista.findViewById(R.id.et_address);
        placescore = vista.findViewById(R.id.fpa_et_score);

        addplace.setOnClickListener(this);
        selectImage.setOnClickListener(this);
        return vista;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fpa_bt_add:
                POIDataBase db = Room.databaseBuilder(vista.getContext(),
                        POIDataBase.class, "database-name").allowMainThreadQueries().build();
                POI poi = new POI(placename.getText().toString(),placeinfo.getText().toString(),placetemp.getText().toString(),placerecomend.getText().toString(),placeaddress.getText().toString(), placescore.getText().toString(),imagePath.getText().toString());
                Long reg = db.poiDAO().insert(poi);
                Toast.makeText(getContext(),"Lugar agregado exitosamente",Toast.LENGTH_LONG).show();
                break;
            case R.id.fpa_bt_image:
                takeImagePath();
                Toast.makeText(getContext(),"Busca tu imagen",Toast.LENGTH_LONG).show();
                break;
        }

    }

    private void takeImagePath() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la dirección"),10);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri path = data.getData();
            File file = new File(path.getPath());
            imagePath.setText(file.getAbsolutePath());
        }
    }
}

