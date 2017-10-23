package com.mateuszzbylut.calcnet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertActivity extends AppCompatActivity {

    private ConvertLogic converter;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        converter = new ConvertLogic();
        layout = (RelativeLayout) findViewById(R.id.activity_convert);

        View view = new View(this);
        fromDec(view);
    }

    public void convertDec() {
        TextView input = (TextView) findViewById(R.id.numberToConvert);
        int dec = Integer.parseInt(input.getText().toString());


        TextView binView = (TextView) findViewById(R.id.outputText);
        TextView octView = (TextView) findViewById(R.id.outputText2);
        TextView hexView = (TextView) findViewById(R.id.outputText3);

        binView.setText("BIN: " + converter.decToBin(dec));
        octView.setText("OCT: " + converter.decToOct(dec));
        hexView.setText("HEX: " + converter.decToHex(dec));

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
    }

    public void convertBin() {
        TextView input = (TextView) findViewById(R.id.numberToConvert);
        String bin = input.getText().toString();

        if (converter.checkBin(bin)) {
            TextView decView = (TextView) findViewById(R.id.outputText);
            TextView octView = (TextView) findViewById(R.id.outputText2);
            TextView hexView = (TextView) findViewById(R.id.outputText3);

            decView.setText("DEC: " + converter.binToDec(bin));
            octView.setText("OCT: " + converter.binToOct(bin));
            hexView.setText("HEX: " + converter.binToHex(bin));
        } else {
            Toast.makeText(this, "Invalid bin", Toast.LENGTH_SHORT).show();
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
    }

    private void convertOct() {
        TextView input = (TextView) findViewById(R.id.numberToConvert);
        String oct = input.getText().toString();

        if (converter.checkOct(oct)) {
            TextView binView = (TextView) findViewById(R.id.outputText);
            TextView decView = (TextView) findViewById(R.id.outputText2);
            TextView hexView = (TextView) findViewById(R.id.outputText3);

            binView.setText("OCT: " + converter.octToBin(oct));
            decView.setText("DEC: " + converter.octToDec(oct));
            hexView.setText("HEX: " + converter.octToHex(oct));
        } else {
            Toast.makeText(this, "Invalid oct", Toast.LENGTH_SHORT).show();
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
    }

    private void convertHex() {
        TextView input = (TextView) findViewById(R.id.numberToConvert);
        String hex = input.getText().toString();

        if (converter.checkHex(hex)) {
            TextView binView = (TextView) findViewById(R.id.outputText);
            TextView octView = (TextView) findViewById(R.id.outputText3);
            TextView decView = (TextView) findViewById(R.id.outputText2);

            binView.setText("BIN: " + converter.hexToBin(hex));
            octView.setText("OCT: " + converter.hexToOct(hex));
            decView.setText("DEC: " + converter.hexToDec(hex));
        } else {
            Toast.makeText(this, "Invalid hex", Toast.LENGTH_SHORT).show();
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
    }

    public void fromBin(View view) {
        TextView binText = (TextView) findViewById(R.id.decTitle);
        binText.setText(R.string.bin);

        EditText editText = (EditText) findViewById(R.id.numberToConvert);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertBin();
            }
        };

        Button binButton = (Button) findViewById(R.id.buttonConvert);
        binButton.setOnClickListener(listener);
    }

    public void fromDec(View view) {
        TextView decText = (TextView) findViewById(R.id.decTitle);
        decText.setText(R.string.dec);

        EditText editText = (EditText) findViewById(R.id.numberToConvert);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertDec();
            }
        };

        Button decButton = (Button) findViewById(R.id.buttonConvert);
        decButton.setOnClickListener(listener);
    }

    public void fromOct(View view) {
        TextView octText = (TextView) findViewById(R.id.decTitle);
        octText.setText(R.string.oct);

        EditText editText = (EditText) findViewById(R.id.numberToConvert);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertOct();
            }
        };

        Button octButton = (Button) findViewById(R.id.buttonConvert);
        octButton.setOnClickListener(listener);
    }

    public void fromHex(View view) {
        TextView hexText = (TextView) findViewById(R.id.decTitle);
        hexText.setText(R.string.hex);

        EditText editText = (EditText) findViewById(R.id.numberToConvert);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertHex();
            }
        };

        Button hexButton = (Button) findViewById(R.id.buttonConvert);
        hexButton.setOnClickListener(listener);
    }
}
