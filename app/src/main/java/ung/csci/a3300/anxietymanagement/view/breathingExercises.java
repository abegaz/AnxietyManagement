package ung.csci.a3300.anxietymanagement.view;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import ung.csci.a3300.anxietymanagement.R;

public class breathingExercises extends AppCompatActivity {
    TextView textView;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);
        //textView = findViewById(R.id.text_view_selected);
        linearLayout = findViewById(R.id.text_view_selected);
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(getBaseContext(), anxiety.class);
        startActivity(intent);
    }
}