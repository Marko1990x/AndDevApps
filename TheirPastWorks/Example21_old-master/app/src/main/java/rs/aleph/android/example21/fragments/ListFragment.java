package rs.aleph.android.example21.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import rs.aleph.android.example21.R;
import rs.aleph.android.example21.async.SimpleSyncTask;

public class ListFragment extends Fragment {

    // Container Activity must implement this interface
    public interface OnProductSelectedListener {
        void onProductSelected(int id);
    }

    OnProductSelectedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SimpleSyncTask task = new SimpleSyncTask(getActivity(), this);
        task.execute("products");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
           listener = (OnProductSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnProductSelectedListener");
        }
    }
}
