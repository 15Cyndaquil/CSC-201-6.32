package com.example.cynda.csc_201_632;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculateBT = (Button) findViewById(R.id.calculateBT);

        final TextView outputTV = (TextView) findViewById(R.id.outputTV);

        final EditText inputET = (EditText) findViewById(R.id.inputET);

        calculateBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    outputTV.setText("Number of Wins: "+runCraps(Integer.parseInt(inputET.getText().toString())));
                }catch (Exception e){outputTV.setText("Invalid Input!");}
            }
        });
    }

    private static String runCraps(int timesToRun){
        int wins=0;

        for(int i = 0; i<timesToRun; i++){
            int roll = roll();
            System.out.println("First Roll: "+roll);
            if(roll==7||roll==11){
                wins++;
                System.out.println("Win\n ");
            }else if(roll==2||roll==3||roll==12){
                System.out.println("Lose\n ");
            }else{
                int firstRoll = roll;
                int rollAgain = 0;
                while(rollAgain==0) {
                    roll = roll();
                    System.out.println("Second Roll: " + roll);
                    if (firstRoll == roll) {
                        wins++;
                        System.out.println("Win\n ");
                        rollAgain=1;
                    } else if (roll == 7) {
                        System.out.println("Lose\n ");
                        rollAgain=1;
                    }
                }
            }
        }
        return String.valueOf(wins);
    }

    public static int roll(){
        int a;
        a =(int) ((Math.random()*6)+(Math.random()*6)+1);
        return a;
    }
}
