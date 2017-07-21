package mm.com.thetpaingsoe.busticketapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreDetailActivity extends AppCompatActivity {

    @BindView(R.id.btn_check)
    Button btncheck;
    @BindView(R.id.btn_purchase)
    Button btnpur;
    @BindView(R.id.rv_bus_chair)
    RecyclerView rvBusChair;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_detail);
        ButterKnife.bind(this, this);

        btnpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Please wait reply from sever",Toast.LENGTH_LONG).show();
            }
        });

        rvBusChair.setLayoutManager(new GridLayoutManager(this, 4));
        rvBusChair.setAdapter(new BusChairAdapter());
    }
}
