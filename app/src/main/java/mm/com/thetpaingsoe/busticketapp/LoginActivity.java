package mm.com.thetpaingsoe.busticketapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText phone, pass;
    private String input_phone, input_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        phone = (EditText) findViewById(R.id.login_phone);
        pass = (EditText) findViewById(R.id.login_password);



        findViewById(R.id.btnregister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginActivity.this, UserRegisterActivity.class);
                startActivity(i);

            }
        });

        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_phone = phone.getText().toString();
                input_pass = pass.getText().toString();
                if (input_phone.equalsIgnoreCase("106") && input_pass.equalsIgnoreCase("admin")) {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class );
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter correct email and password", Toast.LENGTH_LONG).show();
                }

            }
        });

        ((CheckBox)findViewById(R.id.show_hide_password)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (!checked) {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
}
