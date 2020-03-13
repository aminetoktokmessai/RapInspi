package com.severalities.rapinspi;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.Button1);
        Button button2 = findViewById(R.id.Button2);
        Button button3 = findViewById(R.id.Button3);
        Button button4 = findViewById(R.id.Button4);
        Button button5 = findViewById(R.id.Button5);
        button1.getBackground().setAlpha(195);
        button2.getBackground().setAlpha(195);
        button3.getBackground().setAlpha(195);
        button4.getBackground().setAlpha(195);
        button5.getBackground().setAlpha(195);
        View someView = findViewById(R.id.background);
        Random r = new Random();
        int i1 = r.nextInt(10 - 0);
        int temp = R.drawable.background+i1;
        someView.setBackground(getDrawable(temp));
        /*InputStream fstream = getResources().openRawResource(R.raw.arabarray2);
        DataInputStream in = new DataInputStream(fstream);
        final BufferedReader br = new BufferedReader(new InputStreamReader(in));*/
        final Button button = findViewById(R.id.Language);
        View.OnClickListener btnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(MainActivity.this);
                DatabaseHelper2 db2 = null;
                try {
                    db2 = new DatabaseHelper2(MainActivity.this);
                    Button button1 = findViewById(R.id.Button1);
                    button1.setText(db2.getLine(456)+" "+db2.getLine(457)+" "+db2.getLine(458));
                    Button button2 = findViewById(R.id.Button2);
                    button2.setText(db2.getLine(456)+" "+db2.getLine(457)+" "+db2.getLine(458));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        button.setOnClickListener(btnClick);
    }
}
