package com.example.minimo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {


    Button buttonlog;
    private EditText usernametb;
    private String user;
    private TextView textInfo;

//    SharedPreferences userDetails =getSharedPreferences("userdetails", MODE_PRIVATE);
//    SharedPreferences.Editor edit = userDetails.edit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonlog = findViewById(R.id.btnlogin);
        usernametb = findViewById(R.id.edittextUsername);

        //Configuracion

        buttonlog.setOnClickListener(new View.OnClickListener() {

            private String userName; //When we are login
            private Boolean Login = false;
            @Override
            public void onClick(View v) {
                user = usernametb.getText().toString();
                userName = user;
                textInfo = (TextView) findViewById(R.id.info);


                SharedPreferences settings;
                SharedPreferences.Editor editor;
                settings = PreferenceManager.getDefaultSharedPreferences(Login.this);
                editor = settings.edit();
                editor.putString("user", userName);
                editor.commit();

                Intent intent = new Intent(Login.this, Main.class);
                startActivity(intent);//Start
            }
        });
    }
}
