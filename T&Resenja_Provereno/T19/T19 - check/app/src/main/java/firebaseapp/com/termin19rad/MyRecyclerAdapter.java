package firebaseapp.com.termin19rad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<String> data;
    private OnElementClickListener listener;

    public MyRecyclerAdapter(OnElementClickListener listener, List<String> data) {
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;    // ovo nemoze biti null pokrece se metoda kada se pokrene program
            // ovo samo pravi element bez podataka
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // ovo popunjava element sa podacima koji smo napravili u myviewHolder

        holder.bind(listener, data.get(position));
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {   ovo je ok
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Recycle click" + position, Toast.LENGTH_SHORT).show();
            }
        });*/
        //holder.bind(data.get(position));



          // ovo je gde se vezuje listener



    }

    @Override
    public int getItemCount() {
        return data.size(); // vraca velicinu moje liste za pozicije
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvText;
        private View wholeView;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
           // wholeView = itemView;
        }

        public void bind(final OnElementClickListener listener ,final String item){
            tvText.setText(item);
            tvText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onElementClicked(item);
                }
            });


        }
    }

    public interface OnElementClickListener{
        void onElementClicked(String string);

    }


}
