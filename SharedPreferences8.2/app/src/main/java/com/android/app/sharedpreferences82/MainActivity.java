package com.android.app.sharedpreferences82;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_age,et_phone,et_city;
    Button btn_save,btn_show;
    TextView txt_name, txt_age,txt_phone,txt_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         et_name = (EditText)findViewById(R.id.et_name);
         et_age = (EditText)findViewById(R.id.et_age);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_city = (EditText)findViewById(R.id.et_city);
        btn_save = (Button)findViewById(R.id.btn_save);
         btn_show = (Button)findViewById(R.id.btn_show);

        txt_name = (TextView)findViewById(R.id.txt1);
        txt_age = (TextView)findViewById(R.id.txt2);
        txt_phone = (TextView)findViewById(R.id.txt3);
        txt_city = (TextView)findViewById(R.id.txt4);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                savedata();
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaydata();
            }
        });


    }


    private void displaydata() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String name = preferences.getString("Name","");
        String age = preferences.getString("Age","");
        String phone = preferences.getString("Phone","");
        String city = preferences.getString("City","");

        txt_name.setText(name);
        txt_name.setVisibility(View.VISIBLE);

        txt_age.setText(age);
        txt_age.setVisibility(View.VISIBLE);

        txt_phone.setText(phone);
        txt_phone.setVisibility(View.VISIBLE);

        txt_city.setText(city);
        txt_city.setVisibility(View.VISIBLE);
    }

    private void savedata() {
        SharedPreferences preferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Name",et_name.getText().toString());
        editor.putString("Age",et_age.getText().toString());
        editor.putString("Phone",et_phone.getText().toString());
        editor.putString("City",et_city.getText().toString());

        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

}
