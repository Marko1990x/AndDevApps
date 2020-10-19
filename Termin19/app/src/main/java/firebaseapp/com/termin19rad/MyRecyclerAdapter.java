package firebaseapp.com.termin19rad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<String> data;

    public MyRecyclerAdapter(List<String> data) {
        this.data = data;
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
        holder.bind(data.get(position));


    }

    @Override
    public int getItemCount() {
        return data.size(); // vraca velicinu moje liste za pozicije
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvText;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
        }

        public void bind(String item){

            tvText.setText(item);

        }
    }


}
