package ung.csci.a3300.anxietymanagement.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import ung.csci.a3300.anxietymanagement.R;

import java.util.Random;

public class scale extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        radioGroup = findViewById(R.id.radioGroup);

        textView = findViewById(R.id.text_view);
        Intent intent = getIntent();
//        String anxietyLevel = intent.getStringExtra("Patient_Disease");
//        Log.d("found again", anxietyLevel);
//        textView.setText(anxietyLevel);

        Button buttonApply = findViewById(R.id.button_select);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Random rand = new Random();
                int n = rand.nextInt(3)+1;
                switch (n){
                    case 1:
                        Intent intent = new Intent(getBaseContext(), breathingExercises.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getBaseContext(), games.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getBaseContext(), music.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getBaseContext(), food.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getBaseContext(), chat.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getBaseContext(), meetup.class);
                        startActivity(intent6);
                        break;
                }


            }
        });

    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(getBaseContext(), symptoms.class);
        startActivity(intent);
    }
    public void checkButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);




        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_ten:
                if (checked)
                    Toast.makeText(this, "TEN" + radioButton.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_nine:
                if (checked)
                    Toast.makeText(this, "NINE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_eight:
                if (checked)
                    Toast.makeText(this, "EIGHT", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_seven:
                if (checked)
                    Toast.makeText(this, "SEVEN", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_six:
                if (checked)
                    Toast.makeText(this, "SIX", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_five:
                if (checked)
                    Toast.makeText(this, "FIVE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_four:
                if (checked)
                    Toast.makeText(this, "FOUR", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_three:
                if (checked)
                    Toast.makeText(this, "THREE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_two:
                if (checked)
                    Toast.makeText(this, "TWO", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_one:
                if (checked)
                    Toast.makeText(this, "ONE", Toast.LENGTH_SHORT).show();
                break;}


    }
}


    /*public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Selected: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }*/
