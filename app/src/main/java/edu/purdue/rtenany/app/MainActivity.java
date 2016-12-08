package edu.purdue.rtenany.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonEnter;
    TextView viewAlert;

    TextView TextViewOutput1, TextView2Output2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonEnter = (Button)findViewById(R.id.buttonEnter);
        viewAlert = (TextView)findViewById(R.id.textViewAlert);


        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newPanel = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(newPanel);
            }
        });
        Realm.init(this);



    }

    @Override
    public void onClick(View view) {

    }
}
