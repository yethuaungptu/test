package mm.com.thetpaingsoe.busticketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegisterActivity extends AppCompatActivity {

    private EditText name,email,pass;
    private Button btnsingup;

    String uname,uemail,upass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__register);


        name=(EditText)findViewById(R.id.your_full_name);
        email=(EditText)findViewById(R.id.your_email_address);
        pass=(EditText)findViewById(R.id.create_new_password);

        uname=name.getText().toString();
        uemail=email.getText().toString();
        upass=pass.getText().toString();

        btnsingup=(Button)findViewById(R.id.signup);

        btnsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UserRegisterActivity.this,LoginActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Wellcome Pls login ",Toast.LENGTH_LONG).show();

            }
        });


    }
}
