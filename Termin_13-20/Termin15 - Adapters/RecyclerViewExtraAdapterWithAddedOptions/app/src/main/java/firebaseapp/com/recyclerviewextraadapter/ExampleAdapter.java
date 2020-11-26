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
    private OnItemClickListener mListener;
    //this part needs to be created manually

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;


        public ExampleViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            // ovde se preko itemview binduje na xml fajl
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textViewt2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
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
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        ExampleItem currentItem = mExampleList.get(position); // gets curent item
        // sets the data based on the current item passed with position in the array list of items
        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getmText1());
        holder.mTextView2.setText(currentItem.getmText2());

    }

    @Override
    public int getItemCount() {
        // error
        // this method basicly says how many items there will be in our list
        // if its fucking 0 the list will be fucking empty
        // smart i know
        return mExampleList.size();
    }

}
