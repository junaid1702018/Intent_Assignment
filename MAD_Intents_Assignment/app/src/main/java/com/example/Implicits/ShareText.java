package com.example.Implicits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShareText extends AppCompatActivity {
    private Button Share_Btn;
    private TextView Text_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share__text);

        Text_View= findViewById(R.id.textView);
        Share_Btn = findViewById(R.id.sharebtn);

        String text = Text_View.getText().toString();

        Share_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(intent.EXTRA_TEXT, text);
                startActivity(intent1);

            }
        });
    }
}