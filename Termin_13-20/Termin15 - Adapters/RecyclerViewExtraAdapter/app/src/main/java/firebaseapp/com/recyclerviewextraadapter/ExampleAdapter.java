package firebaseapp.com.recyclerviewextraadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {


    //this part needs to be created manually

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ExampleViewHolder(View itemView) {
            super(itemView);
        }
    }


    // these methods are generated but only after making the examplerviewholder
    // class and putting that in the example adapter class in the <>
    //
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
