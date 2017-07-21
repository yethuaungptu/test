package mm.com.thetpaingsoe.busticketapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by myolwin00 on 7/13/17.
 */

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.BusListViewHolder> {


    private String[] busNames;
    private String busPath;
    private OnBusClickListener onBusClickListener;

    public BusListAdapter(OnBusClickListener onBusClickListener) {
        this.onBusClickListener = onBusClickListener;
    }

    public void setBusNames(String[] busNames) {
        this.busNames = busNames;
    }

    public void setBusPath(String busPath) {
        this.busPath = busPath;
    }

    @Override
    public BusListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bus_list_item, parent, false);
        return new BusListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BusListViewHolder holder, int position) {
        holder.tvBusName.setText(busNames[position]);
    }

    @Override
    public int getItemCount() {
        return busNames.length;
    }

    public class BusListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.civ_bus_image)
        CircleImageView civBusImage;

        @BindView(R.id.tv_bus_name)
        TextView tvBusName;

        @BindView(R.id.tv_more_detail)
        TextView tvMore;

        @BindView(R.id.tv_bus_path)
        TextView tvBusPath;

        public BusListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            tvBusPath.setText(busPath);
            civBusImage.setImageResource(R.drawable.bus1);
            tvMore.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onBusClickListener.onBusClick(busNames[getAdapterPosition()]);
        }
    }

    public interface OnBusClickListener {
        void onBusClick(String busName);
    }
}
