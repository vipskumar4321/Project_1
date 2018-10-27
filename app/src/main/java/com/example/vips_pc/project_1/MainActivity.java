package com.example.vips_pc.project_1;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edit_PassCode;
    Button btn_Reset;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_PassCode=findViewById(R.id.edit_PassCode);
        btn_Reset=findViewById(R.id.btn_Reset);

        sharedpreferences = getSharedPreferences("PassCode", MainActivity.this.MODE_PRIVATE);

        edit_PassCode.setText(sharedpreferences.getString("passcode",""));

        btn_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_PassCode=edit_PassCode.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("passcode",str_PassCode);
                editor.commit();
                Toast.makeText(MainActivity.this,"Pass Code changed Successfully.",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
