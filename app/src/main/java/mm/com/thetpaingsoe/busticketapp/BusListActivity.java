package mm.com.thetpaingsoe.busticketapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusListActivity extends AppCompatActivity implements BusListAdapter.OnBusClickListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    @BindView(R.id.rv_bus_list)
    RecyclerView rvBusList;

    @BindView(R.id.slider)
    SliderLayout mSliderLayout;

    private String mBusPath;
    private String[] busNames;
    private BusListAdapter mBusListAdapter;

    public static Intent newIntent(Context context, String busPath) {
        Intent intent = new Intent(context, BusListActivity.class);
        intent.putExtra("bus_path", busPath);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
        ButterKnife.bind(this, this);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Yangon",R.drawable.mpt2);
        file_maps.put("Mandalay",R.drawable.show1);
        file_maps.put("Mawlamyaing",R.drawable.mpt2);
        file_maps.put("Ngwe Saung", R.drawable.show2);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mSliderLayout.addSlider(textSliderView);
        }
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setDuration(1000);
        mSliderLayout.addOnPageChangeListener(this);

        mBusListAdapter = new BusListAdapter(this);
        rvBusList.setLayoutManager(new LinearLayoutManager(this));
        rvBusList.setAdapter(mBusListAdapter);

        mBusPath = getIntent().getStringExtra("bus_path");
        switch (mBusPath) {
            case "Pathein-Yangon":
                busNames = getResources().getStringArray(R.array.pathein_yangon);
                break;
            case "Pathein-Naypyidaw":
                busNames=getResources().getStringArray(R.array.pathein_Naypyidaw);
                break;
            case "Pathein-Mandalay":
                busNames=getResources().getStringArray(R.array.pathain_Mandaly);
                break;
            case "Pathein-Maylamyaing":
                busNames=getResources().getStringArray(R.array.pathain_mawlamyaing);
                break;
            case"Pathein-Chaungthar":
                busNames=getResources().getStringArray(R.array.pathain_chaungthar);
                break;
            case  "Pathein-NgwaSaung":
                busNames=getResources().getStringArray(R.array.pathain_ngwesaung);
                break;
            case "Pathein-MyaungMya":
                busNames=getResources().getStringArray(R.array.pathain_Myaungmya);
                break;
            case "Pathein-Pyay":
                busNames=getResources().getStringArray(R.array.pathain_pyay);
                break;
            case "Pathein-Taungkyi":
                busNames=getResources().getStringArray(R.array.pathain_taungkyi);
                break;
            case  "Pathein-Hintada":
                busNames=getResources().getStringArray(R.array.pathain_hintada);
                break;

        }

        if (mBusPath != null && busNames != null) {
            mBusListAdapter.setBusPath(mBusPath);
            mBusListAdapter.setBusNames(busNames);
        }
    }

    @Override
    public void onBusClick(String busName) {
        Intent i =new Intent(BusListActivity.this,MoreDetailActivity.class);
        startActivity(i);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
