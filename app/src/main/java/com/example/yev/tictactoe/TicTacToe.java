package com.example.yev.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToe extends AppCompatActivity {

    private int counter = 0;
    private boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        Button button1 = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);
        final Button restart = findViewById(R.id.button10);
        restart.setVisibility(View.INVISIBLE);

        final Button[] buttons = {button1,button2,button3,button4,button5,button6,button7,button8,button9};

        for (final Button button: buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userClick(button);
                    Log.d("myCheck", "The sign on the button is: " + button.getText());
                    checkWin(buttons, button, restart);
                }
            });
        }

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame(buttons,restart, (TextView)findViewById(R.id.textView));
            }
        });

        //TextView welcome = findViewById(R.id.te
    }

    protected void userClick(Button button){
        if (counter%2 == 0){
            if(button.getText().equals("")){
                button.setText(R.string.x);
                button.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        }
        else{
            if(button.getText().equals("")){
                button.setText(R.string.o);
                button.setBackgroundColor(getResources().getColor(R.color.red));
            }
        }
        counter++;

        if (counter > 8){
            TextView winnerLabel = findViewById(R.id.textView);
            winnerLabel.setText(R.string.tie);

            findViewById(R.id.button10).setVisibility(View.VISIBLE);
        }
    }

    protected void checkWin(Button[] buttons, Button button, Button restart){
        CharSequence input = button.getText();
        //HORIZONTAL WINS
        if (input.equals(buttons[0].getText()) && input.equals(buttons[1].getText()) && input.equals(buttons[2].getText())){
            win = true;
            Log.d("myWin", "Game won!");
        }
        if (input.equals(buttons[3].getText()) && input.equals(buttons[4].getText()) && input.equals(buttons[5].getText())){
            win = true;
            Log.d("myWin", "Game won!");
        }
        if (input.equals(buttons[6].getText()) && input.equals(buttons[7].getText()) && input.equals(buttons[8].getText())){
            win = true;
            Log.d("myWin", "Game won!");
        }
        //VERTICAL WINS
        if (input.equals(buttons[0].getText()) && input.equals(buttons[3].getText()) && input.equals(buttons[6].getText())){
            win = true;
            Log.d("myWin", "Game won!");
        }
        if (input.equals(buttons[1].getText()) && input.equals(buttons[4].getText()) && input.equals(buttons[7].getText())){
            win = true;
            Log.d("myWin", "Game won!");
        }
        if (input.equals(buttons[2].getText()) && input.equals(buttons[5].getText()) && input.equals(buttons[8].getText())){
            win = true;
            Log.d("myWin", "Game won!");
        }
        //DIAGONAL WINS
        if (input.equals(buttons[0].getText()) && input.equals(buttons[4].getText()) && input.equals(buttons[8].getText())){
            win = true;
            Log.d("myWin", "Game won!");
        }
        if (input.equals(buttons[2].getText()) && input.equals(buttons[5].getText()) && input.equals(buttons[6].getText())){
            win = true;
            Log.d("myWin", "Game won!");
        }

        //IF GAME WON
        if (win){
            TextView winnerLabel = findViewById(R.id.textView);
            if (input.equals("O")){
                winnerLabel.setText(R.string.winnerO);
            }
            else{
                winnerLabel.setText(R.string.winnerX);
            }

            for (Button but : buttons) {
                but.setEnabled(false);
            }

            restart.setVisibility(View.VISIBLE);
        }
    }

    protected void restartGame(Button[] buttons, Button restart, TextView text){
        for (Button but : buttons) {
            but.setEnabled(true);
            but.setBackgroundColor(getResources().getColor(R.color.lightGrey));
            but.setText("");
        }
        restart.setVisibility(View.INVISIBLE);
        text.setText("");
        win = false;
        counter = 0;
    }
}
