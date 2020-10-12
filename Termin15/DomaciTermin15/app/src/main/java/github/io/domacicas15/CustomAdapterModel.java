package github.io.domacicas15;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterModel extends BaseAdapter {  // mora implementirati default metode ili ce pizditi program

    private List<String> data;
    private Activity activity;

    // konstruktor je potreban jer ce praviti objekte
    public CustomAdapterModel(Activity activity, List<String> data) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {  // povezi ga sa xml fajlom nije id
            convertView = activity.getLayoutInflater().inflate(R.layout.customadaptermodel, null);
        }
        TextView TvPrimary = convertView.findViewById(R.id.tvPrimary);
        TvPrimary.setText(data.get(position));
        TextView TvSecondary = convertView.findViewById(R.id.tvSecondary);
        TvSecondary.setText(data.get(position));

        return convertView;
    }
}
