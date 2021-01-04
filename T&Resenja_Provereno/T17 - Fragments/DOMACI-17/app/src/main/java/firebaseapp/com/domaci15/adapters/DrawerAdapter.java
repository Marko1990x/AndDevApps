package firebaseapp.com.domaci15.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import firebaseapp.com.domaci15.Model.NavItem;
import firebaseapp.com.domaci15.R;

public class DrawerAdapter extends BaseAdapter {

    Context context;
    ArrayList<NavItem> items;
  //  ArrayList<NavigationItem> navigationItems;
    // klasa iz modela

// generisan konstruktor
    public DrawerAdapter(Context context, ArrayList<NavItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();  // promenjeno vraca velicinu liste
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);  // returns an item
    }

    @Override
    public long getItemId(int position) {
        return 0;  // returns item id
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_item,null);

        }

        View view;
        TextView tvTitle = convertView.findViewById(R.id.titleDrawer);
        TextView tvSubtitleTextView = convertView.findViewById(R.id.subtitleDrawer);
        ImageView iconImageView = convertView.findViewById(R.id.iconDrawer);

        tvTitle.setText(items.get(position).getTitle());
        tvSubtitleTextView.setText(items.get(position).getSubtitle());
        iconImageView.setImageResource(items.get(position).getIcon());


        return convertView;
    }
}
