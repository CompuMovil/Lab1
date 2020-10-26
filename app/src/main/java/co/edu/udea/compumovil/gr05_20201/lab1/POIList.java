package co.edu.udea.compumovil.gr05_20201.lab1;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.compumovil.gr05_20201.lab1.data.IComunicationFragments;
import co.edu.udea.compumovil.gr05_20201.lab1.data.POIDataBase;
import co.edu.udea.compumovil.gr05_20201.lab1.model.POI;
import co.edu.udea.compumovil.gr05_20201.lab1.model.POIAdapter;


public class POIList extends Fragment {

    Activity activity;
    IComunicationFragments interfaceComFragments;
    View vista;
    List<POI> poiList;
    RecyclerView recyclerPOI;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    public POIList() {
        // Required empty public constructor
    }


    public static POIList newInstance(String param1, String param2) {
        POIList fragment = new POIList();
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

        vista = inflater.inflate(R.layout.list_poi, container, false);
        recyclerPOI = vista.findViewById(R.id.fpl_recycler);
        recyclerPOI.setLayoutManager(new LinearLayoutManager(getActivity()));
        POIDataBase db = Room.databaseBuilder(getActivity(),
                POIDataBase.class, "database-name").allowMainThreadQueries().build();
        poiList = new ArrayList<>();
        poiList = db.poiDAO().getAll();
        inflatePOIAdapter();
        return vista;
    }

    private void inflatePOIAdapter() {
        POIAdapter poiAdapterR = new POIAdapter(poiList);
        poiAdapterR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Selección: "+poiList.get(recyclerPOI.getChildAdapterPosition(view)).getName(),Toast.LENGTH_LONG).show();
                interfaceComFragments.sendPOI(poiList.get(recyclerPOI.getChildAdapterPosition(view)));
            }
        });
        recyclerPOI.setAdapter(poiAdapterR);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            this.activity = (Activity) context;
            interfaceComFragments=(IComunicationFragments) this.activity;
        }
    }
}