package com.example.alesyamikhnyuik.tictac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9;
    private TicTacToeBoard tictactoe;

    public boolean gameOver = false;

    private String player1Name;
    private String player2Name;

    final private char player1Symbol = 'X';
    final private char player2Symbol = 'O';

    private int turnCounter;

    private Coordinates userCoordinates;

    ImageView currentPlayerImage;
    TextView gameStatus;


    private void initializeTTTBoard(){
        tictactoe = new TicTacToeBoard(3);
        Intent intent = getIntent();
        player1Name = intent.getStringExtra("player1Name");
        player2Name = intent.getStringExtra("player2Name");

        turnCounter = 0;

        userCoordinates = new Coordinates(0,0);

        currentPlayerImage = (ImageView) findViewById(R.id.currentPlayerID);
        currentPlayerImage.setImageDrawable(getDrawable(R.drawable.small_ala));

        gameStatus = (TextView) findViewById(R.id.gameStatusID);
        gameStatus.setText(player1Name + ", ваш ход");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initializeTTTBoard();

        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv1.setOnClickListener(new onClickBoard(new Coordinates(0,0), iv1));

        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv2.setOnClickListener(new onClickBoard(new Coordinates(0,1), iv2));

        iv3 = (ImageView) findViewById(R.id.imageView3);
        iv3.setOnClickListener(new onClickBoard(new Coordinates(0,2), iv3));

        iv4 = (ImageView) findViewById(R.id.imageView4);
        iv4.setOnClickListener(new onClickBoard(new Coordinates(1,0), iv4));

        iv5 = (ImageView) findViewById(R.id.imageView5);
        iv5.setOnClickListener(new onClickBoard(new Coordinates(1,1), iv5));

        iv6 = (ImageView) findViewById(R.id.imageView6);
        iv6.setOnClickListener(new onClickBoard(new Coordinates(1,2), iv6));

        iv7 = (ImageView) findViewById(R.id.imageView7);
        iv7.setOnClickListener(new onClickBoard(new Coordinates(2,0), iv7));

        iv8 = (ImageView) findViewById(R.id.imageView8);
        iv8.setOnClickListener(new onClickBoard(new Coordinates(2,1), iv8));

        iv9 = (ImageView) findViewById(R.id.imageView9);
        iv9.setOnClickListener(new onClickBoard(new Coordinates(2,2), iv9));


        Button exitButton = (Button) findViewById(R.id.exitButtonID);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameActivity.this.finish();
            }
        });

        Button playAgainButton = (Button) findViewById(R.id.playAgainButtonID);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameActivity.this.finish();
                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                intent.putExtra("player1Name", player1Name);
                intent.putExtra("player2Name", player2Name);
                GameActivity.this.startActivity(intent);
                gameOver = false;
            }
        });
    }

    private class onClickBoard implements View.OnClickListener {

        Coordinates coordinates;
        onClickBoard(Coordinates coordinates, ImageView imageClick){
            this.coordinates = coordinates;
        }


        @Override
        public void onClick(View view) {
            Log.d("ImageView Coordinates: ", Integer.toString(coordinates.getRow()) + ", " + Integer.toString(coordinates.getCol()));


            if(gameOver){
                Toast.makeText(GameActivity.this, "Ошибка: Игра окончена!", Toast.LENGTH_LONG).show();
                return;
            }

            if(coordinates.getCheckRepeat()){
                Toast.makeText(GameActivity.this, "Ошибка: Эта ячейка уже заполнена!", Toast.LENGTH_LONG).show();
                return;
            }

            turnCounter++;
            if(turnCounter%2 == 0){

                ((ImageView)view).setImageDrawable(getDrawable(R.drawable.gugui));


                gameStatus = (TextView) findViewById(R.id.gameStatusID);
                gameStatus.setText(player1Name + ", ваш ход!");


                tictactoe.makeMove(coordinates, player1Symbol);
                coordinates.setCheckRepeat(true);


                if(tictactoe.isWinner(player1Symbol)){
                    gameStatus.setText("Поздравлем, " + player2Name + "! Вы победили! Хотите сыграть еще?");
                    gameOver = true;
                    return;

                }else if(tictactoe.isFull()){
                    gameStatus.setText("Поле заполнено! В этой игре победителей нет:(");
                    gameOver = true;
                    return;


                }else{
                    currentPlayerImage = (ImageView) findViewById(R.id.currentPlayerID);
                    currentPlayerImage.setImageDrawable(getDrawable(R.drawable.small_ala));
                }

            }
            else {
                ((ImageView) view).setImageDrawable(getDrawable(R.drawable.ala));



                gameStatus = (TextView) findViewById(R.id.gameStatusID);
                gameStatus.setText(player2Name + ", ваш ход");

                tictactoe.makeMove(coordinates, player2Symbol);
                coordinates.setCheckRepeat(true);


                if (tictactoe.isWinner(player2Symbol)) {
                    gameStatus.setText("Поздравлем, " + player1Name + "! Вы победили! Хотите сыграть еще?");
                    gameOver = true;
                    return;


                }else if(tictactoe.isFull()){
                    gameStatus.setText("Поле заполнено! В этой игре победителей нет:(");
                    gameOver = true;
                    return;


                }else{
                    currentPlayerImage = (ImageView) findViewById(R.id.currentPlayerID);
                    currentPlayerImage.setImageDrawable(getDrawable(R.drawable.small_gugui));
                }

            }

        }
    }

}