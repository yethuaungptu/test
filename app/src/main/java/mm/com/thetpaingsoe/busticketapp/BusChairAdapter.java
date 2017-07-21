package mm.com.thetpaingsoe.busticketapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BusChairAdapter extends RecyclerView.Adapter<BusChairAdapter.BusChairViewHolder> {

    public BusChairAdapter() {
    }

    @Override
    public BusChairViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_bus_chair, parent, false);
        return new BusChairViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BusChairViewHolder holder, int position) {
        holder.tvBusChairId.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return 44;
    }

    public class BusChairViewHolder extends RecyclerView.ViewHolder {

        TextView tvBusChairId;

        public BusChairViewHolder(View itemView) {
            super(itemView);
            tvBusChairId = (TextView) itemView.findViewById(R.id.tv_bus_chair_id);
        }
    }
}
