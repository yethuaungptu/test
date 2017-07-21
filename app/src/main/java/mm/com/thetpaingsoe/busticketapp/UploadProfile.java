package mm.com.thetpaingsoe.busticketapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadProfile extends AppCompatActivity {

    private Calendar calendar;

    @BindView(R.id.edt_bd_date)
    EditText edtDay;
    @BindView(R.id.edt_bd_month)
    EditText edtMonth;
    @BindView(R.id.edt_bd_year)
    EditText edtYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_profile);
        ButterKnife.bind(this, this);
        calendar = Calendar.getInstance();
    }

    @OnClick(R.id.iv_calendar) void onClick() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                Toast.makeText(UploadProfile.this, date, Toast.LENGTH_SHORT).show();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
