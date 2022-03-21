package com.example.velasquez_chinhotelreservation;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

public class Booking extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);

        Button buttonApply = findViewById(R.id.button_apply);

        buttonApply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                textView.setText("Your choice: " + radioButton.getText());
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}