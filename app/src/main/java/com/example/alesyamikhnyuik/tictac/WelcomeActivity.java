package com.example.alesyamikhnyuik.tictac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class WelcomeActivity extends AppCompatActivity {

    Button exitBtn;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                finish();
                return true;
        }
        return super.onOptionsItemSelected (item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button playButton = (Button) findViewById(R.id.playButtonID);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText player1EditText = (EditText) findViewById(R.id.player1InputID);
                String player1Name = player1EditText.getText().toString();

                EditText player2EditText = (EditText) findViewById(R.id.player2InputID);
                String player2Name = player2EditText.getText().toString();

                Intent intent = new Intent(WelcomeActivity.this, GameActivity.class);
                intent.putExtra("player1Name", player1Name);
                intent.putExtra("player2Name", player2Name);

                WelcomeActivity.this.startActivity(intent);
            }
        });
    }

}
