package firebaseapp.com.customadapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class mojAdapter extends BaseAdapter {
        // u ovoj metodi se nepune podaci nego samo model adaptera treba konstruktor
    private List<String>strings; // ovo je isto trebaju mi podaci
    private Activity activity;

    public mojAdapter(Activity activity,List<String> strings) {

        this.activity = activity;
        this.strings = strings;
    }

    // poenta je da kada imam vise od jenog elementa koji se prikazuje sa adapterom da moram da korstim custom adapter
    // koji extenduje base adapter


    @Override
    public int getCount() {
        return strings.size(); // velicina liste preko strings.size
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;  // return 0
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.my_layout_items, null);
            // ako je konvert prazan onda activity puni layout sa mojim xml fajlom od koga je root null

        }

        TextView tvPrimary = convertView.findViewById(R.id.tvPrimary);
        tvPrimary.setText(strings.get(position));
        TextView tvSecondary = convertView.findViewById(R.id.tvSecond);
        tvSecondary.setText(strings.get(position));

        // znaci poenta ovde je napraviti convert view koji ces vratiti adapteru koji ce to da prikaze
        return convertView;
    }




}
