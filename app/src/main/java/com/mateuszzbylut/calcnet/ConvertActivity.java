package com.mateuszzbylut.calcnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
    }

    public void convertDecToBin(View view) {
        TextView input = (TextView) findViewById(R.id.numberToConvert);
        int dec = Integer.parseInt(input.getText().toString());

        ConvertLogic converter = new ConvertLogic();
        String output = converter.decToBin(dec);

        TextView outputView = (TextView) findViewById(R.id.outputText);
        outputView.setText(output);
    }
}
