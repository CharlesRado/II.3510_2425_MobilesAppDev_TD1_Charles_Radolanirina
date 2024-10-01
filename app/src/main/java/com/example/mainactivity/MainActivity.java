package com.example.mainactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private boolean isRed = false;
    private boolean isLarge = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Widgets recuperation
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        Button buttonChangeColor = findViewById(R.id.buttonChangeColor);
        Button buttonChangeSize = findViewById(R.id.buttonChangeSize);

        // Define an action for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the text from EditText and display it into TextView
                String text = editText.getText().toString();
                textView.setText(text);
            }
        });

        // Define an action for the button of color changing
        buttonChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRed) {
                    textView.setTextColor(Color.BLACK);
                } else {
                    textView.setTextColor(Color.RED);
                }
                isRed = !isRed;
            }
        });

        // Define an action for the button of size changing
        buttonChangeSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLarge) {
                    textView.setTextSize(18);
                } else {
                    textView.setTextSize(24);
                }
                isLarge = !isLarge;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}