package com.example.tema6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText periodInput;
    private EditText volumeInput;
    private EditText durationInput;
    private Button startServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        periodInput = findViewById(R.id.period_input);
        volumeInput = findViewById(R.id.volume_input);
        durationInput = findViewById(R.id.duration_input);
        startServiceButton = findViewById(R.id.start_service_button);

        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int period = Integer.parseInt(periodInput.getText().toString());
                int volume = Integer.parseInt(volumeInput.getText().toString());
                int duration = Integer.parseInt(durationInput.getText().toString());

                Intent serviceIntent = new Intent(MainActivity.this, SoundService.class);
                serviceIntent.putExtra("period", period);
                serviceIntent.putExtra("volume", volume);
                serviceIntent.putExtra("duration", duration);
                startService(serviceIntent);
            }
        });
    }
}
