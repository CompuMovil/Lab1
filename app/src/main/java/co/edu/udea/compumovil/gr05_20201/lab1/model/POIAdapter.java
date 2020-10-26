package co.edu.udea.compumovil.gr05_20201.lab1.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.edu.udea.compumovil.gr05_20201.lab1.R;

public class POIAdapter extends RecyclerView.Adapter<POIAdapter.ViewHolderPOIInfo> implements View.OnClickListener{

    List<POI> poiList;
    View vista;
    private View.OnClickListener listener;

    public POIAdapter(List<POI> poiList) {
        this.poiList = poiList;
    }

    @NonNull
    @Override
    public ViewHolderPOIInfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        vista = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.card_places,parent,false);
        vista.setOnClickListener(this);
        return new ViewHolderPOIInfo(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull POIAdapter.ViewHolderPOIInfo holder, int position) {

        holder.placename.setText(poiList.get(position).name);
        holder.placeinfo.setText(poiList.get(position).information);
        holder.placescore.setText(poiList.get(position).score);
    }

    @Override
    public int getItemCount() {
        return poiList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderPOIInfo extends RecyclerView.ViewHolder {

        ImageView photo;
        TextView placename, placeinfo, placescore;

        public ViewHolderPOIInfo(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.il_iv_image);
            placename = itemView.findViewById(R.id.il_tv_name);
            placeinfo = itemView.findViewById(R.id.il_tv_information);
            placescore = itemView.findViewById(R.id.il_tv_score);
        }
    }
}
