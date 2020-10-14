package github.io.radnacasu17;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    private TextView tvName;
    private int id;

    public DetailsFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);

    }

    private void setupViews(){
        tvName.setText(NamesProvider.getNameById(id));
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName = view.findViewById(R.id.tvName); // clean i rebuild ako nesto zabaguje

        setupViews(); // ovde treba da je zovem

    }

    public void setId(int id){
        this.id = id;
    }

    public void udpateId(int id){
        this.id = id;
        tvName.setText(NamesProvider.getNameById(id));
    }



}