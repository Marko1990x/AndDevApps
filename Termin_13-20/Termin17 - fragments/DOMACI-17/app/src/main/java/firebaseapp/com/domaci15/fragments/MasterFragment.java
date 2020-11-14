package firebaseapp.com.domaci15.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import firebaseapp.com.domaci15.Provider.JeloProvider;
import firebaseapp.com.domaci15.R;

public class MasterFragment extends Fragment {

    OnItemSelectedListener Listener;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> imenajela = JeloProvider.getJeloNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, imenajela);
        // vuce list item koji ima samo txt polje da popuni sa podacima
        ListView listView = getActivity().findViewById(R.id.listaOfJela);
        // ovo je veza izmeju fragmenta i liste
        // prakticno kaze popunjena list item lista ce biti slepljena u master fragment na view sa id listaofjela
        // koji je samo kontainner list view
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Listener.onItemSelected(position);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (container==null){
            return null;
        }

        View view = inflater.inflate(R.layout.fragment_master, container,false);

        return view;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        try {
            Listener = (OnItemSelectedListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ "Must imlement on item selected listener.");
        }
    }

    public interface OnItemSelectedListener{
        public void onItemSelected(int position);
    }
}
