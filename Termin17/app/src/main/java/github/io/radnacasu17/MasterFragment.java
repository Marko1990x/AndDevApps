package github.io.radnacasu17;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


public class MasterFragment extends Fragment {

    private ListView lvNames;
    private List<String> names;
    private onNameClickListener listener;

    public MasterFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvNames = view.findViewById(R.id.LvNames);
        setUpList();
    }

    private void setUpList(){
       names = NamesProvider.getAllNames();
       // fragment nema kontext
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, names);
        // context , layout , lista podataka

        lvNames.setAdapter(adapter);
    }

    // Mora imati interface

    interface onNameClickListener{

        // sve metode su public

        void onNameClicked(int id);

    }


}