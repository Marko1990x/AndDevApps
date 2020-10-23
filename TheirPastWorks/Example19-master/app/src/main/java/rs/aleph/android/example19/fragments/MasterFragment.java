package rs.aleph.android.example19.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import rs.aleph.android.example19.R;
import rs.aleph.android.example19.adapters.FruitAdapter;
import rs.aleph.android.example19.providers.FruitProvider;

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

        // Creates an Adapter for fruits
        FruitAdapter dataAdapter = new FruitAdapter((OnItemSelectedListener) getActivity(), fruitNames);
        RecyclerView listView = (RecyclerView) getActivity().findViewById(R.id.listofFruits);
        // Set layout manager
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Assigns Adapter to RecycleView
        listView.setAdapter(dataAdapter);

    }

    // onCreateView method is a life-cycle method that is called to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "MasterFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        if (container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.fragment_master, container, false);

        return view;
    }

    // onAttach method is a life-cycle method that is called when a fragment is first attached to its context.
    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "MasterFragment.onAttach()", Toast.LENGTH_SHORT).show();

        try {
            listener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }
    }

    // Container activity must implement this interface
    public interface OnItemSelectedListener {

        public void onItemSelected(int position);
    }
}
