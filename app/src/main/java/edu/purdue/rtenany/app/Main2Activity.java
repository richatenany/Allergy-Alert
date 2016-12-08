package edu.purdue.rtenany.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button submitButton;
    private EditText enterAllergy;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        enterAllergy = (EditText)findViewById(R.id.enterAllergy);
        realm = Realm.getDefaultInstance();
        submitButton = (Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String nameofAllergy = enterAllergy.getText().toString();
        Allergy food = new Allergy();
        food.setName(nameofAllergy);

        realm.beginTransaction(); //open database
        realm.copyToRealm(food); //saving it
        realm.commitTransaction();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Intent newPanel = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(newPanel);
            }
        });


    }
}
