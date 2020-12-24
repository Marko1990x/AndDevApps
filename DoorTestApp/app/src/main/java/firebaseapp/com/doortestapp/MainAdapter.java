package firebaseapp.com.doortestapp;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<MainData> dataList;
    private Activity context;
    private RoomDB database;

    // create constructor


    public MainAdapter( Activity context, List<MainData> dataList) {
        this.dataList = dataList;
        this.context = context;
        notifyDataSetChanged();  // for adapter to refresh data
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //initialize main data
        MainData data = dataList.get(position);
        database = RoomDB.getInstance(context);
        holder.textView.setText(data.getText());
        holder.bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initialize main data
                MainData d = dataList.get(holder.getAdapterPosition());
                //get id
                int sID = d.getID();
                //get text
                String sText = d.getText();

                //create dialog
                Dialog dialog = new Dialog(context);
                //set content view
                dialog.setContentView(R.layout.dialog_update);

                //Initialize width
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                //Initialize Height
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                //Set layout
                dialog.getWindow().setLayout(width,height);
                //show dialog
                dialog.show();
                //initialize and asign variables
                EditText editText = dialog.findViewById(R.id.edit_text);
                Button btUpdate = dialog.findViewById(R.id.bt_update);
                //set text on edit text
                editText.setText(sText);
                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // dismiss dialog
                        dialog.dismiss();
                        // get updated text from edit text
                        String uText = editText.getText().toString().trim();
                        //update text in database
                        database.mainDao().update(sID,uText);
                        dataList.clear();
                        dataList.addAll(database.mainDao().getAll());
                        notifyDataSetChanged();

                    }
                });

            }
        });

        holder.bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // initialize main data
                MainData d = dataList.get(holder.getAdapterPosition());
                // delete text from database
                database.mainDao().delete(d);
                int position = holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,dataList.size());



            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //init variables
        TextView textView;
        ImageView bt_edit, bt_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variabes
            textView = itemView.findViewById(R.id.text_view);
            bt_edit = itemView.findViewById(R.id.edit_text);
            bt_delete = itemView.findViewById(R.id.bt_delete);
        }
    }
}
