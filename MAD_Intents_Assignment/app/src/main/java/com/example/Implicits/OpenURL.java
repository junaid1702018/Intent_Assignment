package com.example.Implicits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OpenURL extends AppCompatActivity {

    private EditText edit_Text;
    private Button Load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_url);

        edit_Text = findViewById(R.id.edittext);
        Load = findViewById(R.id.loadBtn);


        Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String URL = editText.getText().toString();
                Intent intent1 = new Intent( Intent.ACTION_VIEW, Uri.parse(URL));
                Intent chooser = Intent.createChooser(intent,"Choose from Appication");

                if (intent1.resolveActivity(getPackageManager())!=null){
                    startActivity(chooser);
                }
            }
        });
    }
}