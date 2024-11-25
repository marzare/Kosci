package com.example.kosci;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int gameResult = 0;
    private TextView rollResultView;
    private TextView gameResultView;
    private ImageView[] diceViews = new ImageView[5];
    private int[] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceViews[0] = findViewById(R.id.dice1);
        diceViews[1] = findViewById(R.id.dice2);
        diceViews[2] = findViewById(R.id.dice3);
        diceViews[3] = findViewById(R.id.dice4);
        diceViews[4] = findViewById(R.id.dice5);

        rollResultView = findViewById(R.id.rollResult);
        gameResultView = findViewById(R.id.gameResult);

        Button rollButton = findViewById(R.id.rollDiceButton);
        Button resetButton = findViewById(R.id.resetButton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    private void rollDice() {
        Random random = new Random();
        int rollResult = 0;

        for (int i = 0; i < 5; i++) {
            int diceRoll = random.nextInt(6) + 1;
            diceViews[i].setImageResource(diceImages[diceRoll - 1]);
            rollResult += diceRoll;
        }

        rollResultView.setText("Wynik tego losowania: " + rollResult);
        gameResult += rollResult;
        gameResultView.setText("Wynik gry: " + gameResult);
    }

    private void resetGame() {
        for (ImageView diceView : diceViews) {
            diceView.setImageResource(R.drawable.question);
        }
        rollResultView.setText("Wynik tego losowania: 0");
        gameResult = 0;
        gameResultView.setText("Wynik gry: 0");
    }
}