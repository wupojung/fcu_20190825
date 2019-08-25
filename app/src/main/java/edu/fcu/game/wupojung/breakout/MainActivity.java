package edu.fcu.game.wupojung.breakout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is an demo , just jump to second Scene
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, InGameActivity.class);
        startActivity(intent);
    }
}
