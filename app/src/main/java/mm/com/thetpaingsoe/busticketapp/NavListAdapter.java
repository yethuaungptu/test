package mm.com.thetpaingsoe.busticketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Owner on 7/15/2017.
 */

public class NavListAdapter extends BaseAdapter {

    private Context context;
    private String[]arg;
    private int imgId[] = {R.drawable.profile, R.drawable.history, R.drawable.ticket, R.drawable.invite, R.drawable.content, R.drawable.about};
    public NavListAdapter(Context context,String arg[]){
        this.context=context;
        this.arg=arg;
    }

    public int getCount() {
        return arg.length;
    }

    @Override
    public Object getItem(int position) {
        return arg[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            LayoutInflater li = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.nav_list_view,null);
        }
        ImageView imgView = (ImageView)convertView.findViewById(R.id.imgView);
        TextView txtView = (TextView)convertView.findViewById(R.id.txtView);
        imgView.setImageResource(imgId[position]);
        txtView.setText(arg[position]);
        return convertView;
    }
}
