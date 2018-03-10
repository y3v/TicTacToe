package com.example.yev.tictactoe;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class EnterNamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_names);

        final TextInputEditText player1 = (TextInputEditText) findViewById(R.id.player1);
        final TextInputEditText player2 = (TextInputEditText) findViewById(R.id.player2);

        Button startButton = findViewById(R.id.button11);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkIfEmpty(player1, player2)){
                    startTicTacToe(player1.getText(),player2.getText());
                }
                //startTicTacToe("Yev", "Wow");
            }
        });
    }

    private boolean checkIfEmpty(TextInputEditText player1, TextInputEditText player2){
        player1.setError(null);
        player2.setError(null);

        boolean empty = false;

        if (TextUtils.isEmpty(player1.getText())){
            player1.setError("Please enter a name for player 1");
            empty = true;
        }
        if (TextUtils.isEmpty(player2.getText())){
            player2.setError("Please enter a name for player 2");
            empty = true;
        }

        return empty;
    }

    private void startTicTacToe(CharSequence player1, CharSequence player2){
        Intent intent = new Intent(this, TicTacToe.class);
        intent.putExtra("player1", player1);
        intent.putExtra("player2", player2);
        startActivity(intent);
    }
}
