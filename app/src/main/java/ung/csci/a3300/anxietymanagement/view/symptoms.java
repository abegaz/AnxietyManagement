package ung.csci.a3300.anxietymanagement.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import ung.csci.a3300.anxietymanagement.R;


public class symptoms extends AppCompatActivity{

    RadioGroup radioGroup2;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        radioGroup2 = findViewById(R.id.radioGroup2);

        textView = findViewById(R.id.text_view);

        Button buttonApply = findViewById(R.id.button_select);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup2.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                Intent intent = new Intent(getBaseContext(), scale.class);
                int selectedRadioButtonID = radioGroup2.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                if(selectedRadioButton!=null){
                    String s = selectedRadioButton.getText().toString();
                    Log.d("value found", s);
                    intent.putExtra("Patient_Disease", s);
                    finish();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getBaseContext(), "Please pick at least one", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}



