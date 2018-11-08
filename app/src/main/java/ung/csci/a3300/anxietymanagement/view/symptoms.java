package ung.csci.a3300.anxietymanagement.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import ung.csci.a3300.anxietymanagement.R;


public class symptoms extends AppCompatActivity{

    LinearLayout radioGroup2;
    RadioButton radioButton;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        //radioGroup2 = findViewById(R.id.radioGroup2);

        textView = findViewById(R.id.text_view);

        Button buttonApply = findViewById(R.id.button_select);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int radioId = radioGroup2.getC;
                // radioButton = findViewById(radioId);
                Intent intent = new Intent(getBaseContext(), scale.class);
                // int selectedRadioButtonID = radioGroup2.getCheckedRadioButtonId();
                //RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                //String s = selectedRadioButton.getText().toString();
                // Log.d("value found", s);
                //intent.putExtra("Patient_Disease", s);

                startActivity(intent);
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



