package com.pollub.txt_to_sp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton elma,armut,erik ;
    TTSManager ttsManager = null;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttsManager = new TTSManager();
        ttsManager.init(this);

        elma =findViewById(R.id.imageButton2);
        armut=findViewById(R.id.imageButton3);
        erik=findViewById(R.id.imageButton4);

        elma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="elma";
                ttsManager.initQueue(text);
            }
        });
        armut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="armut";
                ttsManager.initQueue(text);
            }
        });
        erik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="erik";
                ttsManager.initQueue(text);
            }
        });


    }

    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}
