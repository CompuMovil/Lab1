package co.edu.udea.compumovil.gr05_20201.lab1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link POIDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class POIDetail extends Fragment {

    TextView id,place_name,place_temperature, place_address, place_recommend,place_info,place_score;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public POIDetail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static POIDetail newInstance(String param1, String param2) {
        POIDetail fragment = new POIDetail();
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
        View vista = inflater.inflate(R.layout.poi_detail, container, false);
        place_name = vista.findViewById(R.id.fpa_et_name);
        place_temperature = vista.findViewById(R.id.fpa_et_temperature);
        place_info = vista.findViewById(R.id.fpa_et_information);
        place_address = vista.findViewById(R.id.et_address);
        place_recommend = vista.findViewById(R.id.fpa_et_recomendation);
        place_score = vista.findViewById(R.id.fpa_et_score);


        Bundle bundleGetter = getArguments();
        POI poi = null;
        if(bundleGetter != null){
            poi = (POI) bundleGetter.getSerializable("Object");
            //id.setText(poi.getId());
            place_name.setText(poi.getName());
            place_temperature.setText(poi.getTemperature());
            place_info.setText(poi.getInformation());
            place_address.setText(poi.getAddress());
            place_recommend.setText(poi.getRecommendation());
            place_score.setText(poi.getScore());
        }

        return vista;
    }
}