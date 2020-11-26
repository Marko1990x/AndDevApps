package firebaseapp.com.recyclerviewextraadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;// this is for the data that the adapter will use

    //this part needs to be created manually

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mViewName;
        public TextView mViewName2;



        public ExampleViewHolder(View itemView) {
            super(itemView);
            // ovde se preko itemview binduje na xml fajl
            mImageView = itemView.findViewById(R.id.imageView);
            mViewName= itemView.findViewById(R.id.textView);
            mViewName2 = itemView.findViewById(R.id.textViewt2);
        }
    }

    public  ExampleAdapter(ArrayList<ExampleItem> exampleList){
        // needs a global declartion which containts examplelist variable because whenever we create the adapter this thing
        // needs to be declared
        mExampleList = exampleList;
    }

    // these methods are generated but only after making the examplerviewholder
    // class and putting that in the example adapter class in the <>
    //
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // this basicly takes the xml file that we created
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        ExampleItem currentItem = mExampleList.get(position); // gets curent item
        // sets the data based on the current item passed with position in the array list of items
        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mViewName.setText(currentItem.getmText1());
        holder.mViewName2.setText(currentItem.getmText2());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
