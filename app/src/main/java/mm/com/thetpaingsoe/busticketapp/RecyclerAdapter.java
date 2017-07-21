package mm.com.thetpaingsoe.busticketapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

import butterknife.ButterKnife;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    String[] names = {
            "Pathein-Yangon", "Pathein-Mandalay", "Pathein-Naypyidaw", "Pathein-Maylamyaing", "Pathein-Chaungthar",
            "Pathein-NgwaSaung", "Pathein-MyaungMya", "Pathein-Pyay", "Pathein-Taungkyi", "Pathein-Hintada"
    };

    int[] images = {
            R.drawable.yangon, R.drawable.mandalay, R.drawable.naypyidaw, R.drawable.mawlamyaing, R.drawable.chaungthar,
            R.drawable.ngwesaung, R.drawable.myaungmya, R.drawable.pyay, R.drawable.taungkyi, R.drawable.hintada
    };

    private OnItemClickListener onItemClickListener;

    public RecyclerAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvName.setText(names[position]);
        holder.ivBusImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_bus_image)
        ImageView ivBusImage;

        @BindView(R.id.tv_name)
        TextView tvName;

        @BindView(R.id.btn_see_more)
        Button btnMore;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            btnMore.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(names[getAdapterPosition()]);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String name);
    }

}
