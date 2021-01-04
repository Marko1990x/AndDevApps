package rs.aleph.android.example18.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import rs.aleph.android.example18.R;
import rs.aleph.android.example18.providers.FruitProvider;

// Each Fragment extends Fragment class
public class MasterFragment extends Fragment {

    OnItemSelectedListener listener;

    // onActivityCreated method is a life-cycle method that is called when the fragment's activity has been created and this fragment's view hierarchy instantiated.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "MasterFragment.onActivityCreated()", Toast.LENGTH_SHORT).show();

        // Loads fruits from array resource
        final List<String> fruitNames = FruitProvider.getFruitNames();

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, fruitNames);
        ListView listView = getActivity().findViewById(R.id.listofFruits);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);

        // Updates DetailFragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(position);
            }
        });

    }

    // onCreateView method is a life-cycle method that is called to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "MasterFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        if (container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.fragment_master, container, false);

        return view;
    }

    // onAttach method is a life-cycle method that is called when a fragment is
    // first attached to its context.
    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "MasterFragment.onAttach()", Toast.LENGTH_SHORT).show();

        try {
            listener = (OnItemSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnItemSelectedListener");
        }
    }

    // Container activity must implement this interface
    public interface OnItemSelectedListener {

        void onItemSelected(int position);
    }
}
