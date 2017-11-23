package com.example.android.simplegames;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int rando() {
        Random aaaa = new Random();
        return aaaa.nextInt(100);
    }

    // global variables
    int losowa1 = rando();
    int counting = 0;
    int numberOfRound = 1;
    // global variables player A
    String badAnswersA = "";
    int x;
    int playApoints = 0;
    // global variables player B
    String badAnswersB = "";
    int y;
    int playBpoints = 0;

    //reset button
    public void reset(View view) {
        losowa1 = rando();
        counting = 0;
        numberOfRound = 1;
        roundsShow("");
        badAnswersA = "";
        badAnswersB = "";
        playApoints = 0;
        playBpoints = 0;
        TextView info = findViewById(R.id.attempt1);
        info.setText("");
        TextView badA = findViewById(R.id.badAnswer1);
        badA.setText("");
        TextView info2 = findViewById(R.id.attempt2);
        info2.setText("");
        TextView badB = findViewById(R.id.badAnswer2);
        badB.setText("");
        TextView showRound = findViewById(R.id.title_attempt);
        showRound.setText(getString(R.string.attempt1String));
    }

    //display Text Views
    public void showingA(String wysoko_nisko) {
        TextView line2 = findViewById(R.id.title_attempt);
        line2.setText(getString(R.string.attemptNo) + counting);
        TextView info = findViewById(R.id.attempt1);
        info.setText(getString(R.string.enteredNo)+" "+" " + x + wysoko_nisko);

    }

    public void showingB(String wysoko_nisko) {
        TextView line2 = findViewById(R.id.title_attempt);
        line2.setText(getString(R.string.attemptNo) + counting);
        TextView info = findViewById(R.id.attempt2);
        info.setText(getString(R.string.enteredNo)+" " + " " + y + wysoko_nisko);

    }

    public void showBadAnswerA() {
        TextView badA = findViewById(R.id.badAnswer1);
        badA.setText(badAnswersA);
    }

    public void showBadAnswerB() {
        TextView badB = findViewById(R.id.badAnswer2);
        badB.setText(badAnswersB);
    }

    public void playerApoints() {
        TextView Apoints = findViewById(R.id.playerA);
        Apoints.setText(getString(R.string.playerA) + playApoints);
    }

    public void playerBpoints() {
        TextView Bpoints = findViewById(R.id.playerB);
        Bpoints.setText(getString(R.string.playerB) + playBpoints);
    }

    public void roundsShow(String newNumber) {
        TextView showRound = findViewById(R.id.title_attempt);
        showRound.setText(getString(R.string.runda) + numberOfRound + newNumber);
        TextView rundaGlowna = findViewById(R.id.round);
        rundaGlowna.setText(getString(R.string.runda) + numberOfRound);
    }

    // check button player A
    public void checking(View view) {

        EditText shoot_1 = findViewById(R.id.shoot1);
        String attempt1 = shoot_1.getText().toString();

        if (TextUtils.isEmpty(attempt1)) {
            shoot_1.setError(getString(R.string.typeNumberError));
            return;
        } else {
            x = Integer.parseInt(shoot_1.getText().toString());


            if (x > losowa1) {
                counting++;
                showingA(getString(R.string.tooMuch));
                badAnswersA += x + ",";
                showBadAnswerA();
                shoot_1.setText("");
            } else if (x < losowa1) {
                counting++;
                showingA(getString(R.string.notEnough));
                badAnswersA += x + ",";
                showBadAnswerA();
                shoot_1.setText("");
            } else {
                counting++;
                numberOfRound += 1;
                playApoints++;
                showingA("\n"+getString(R.string.winner) + "\n" + getString(R.string.pointAdded));
                roundsShow("\n\n" + getString(R.string.newNumberDraw));
                playerApoints();
                shoot_1.setText("");
                losowa1 = rando();
                counting = 0;
                TextView badA = findViewById(R.id.badAnswer1);
                badA.setText("");
                TextView badB = findViewById(R.id.badAnswer2);
                badB.setText("");
                badAnswersA = "";
                badAnswersB = "";
            }
        }
    }
// second player

    public void checking2(View view) {
        EditText shoot_2 = findViewById(R.id.shoot2);
        String attempt2 = shoot_2.getText().toString();
        if (TextUtils.isEmpty(attempt2)) {
            shoot_2.setError(getString(R.string.typeNumberError));
            return;
        } else {
            y = Integer.parseInt(shoot_2.getText().toString());
            if (y > losowa1) {
                counting++;
                showingB(getString(R.string.tooMuch));
                badAnswersB += y + ",";
                showBadAnswerB();
                shoot_2.setText("");
            } else if (y < losowa1) {
                counting++;
                showingB(getString(R.string.notEnough));
                badAnswersB += y + ",";
                showBadAnswerB();
                shoot_2.setText("");
            } else {
                counting++;
                numberOfRound += 1;
                playBpoints++;
                showingB("\n"+getString(R.string.winner) + "\n" + getString(R.string.pointAdded));
                roundsShow("\n\n" + getString(R.string.newNumberDraw));
                playerBpoints();
                shoot_2.setText("");
                losowa1 = rando();
                counting = 0;
                TextView badA = findViewById(R.id.badAnswer1);
                badA.setText("");
                TextView badB = findViewById(R.id.badAnswer2);
                badB.setText("");
                badAnswersA = "";
                badAnswersB = "";
            }
        }
    }
}
