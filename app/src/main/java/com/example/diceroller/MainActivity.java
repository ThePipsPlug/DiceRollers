package com.example.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView PC;
    ArrayList<String> Qs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PC = (TextView)findViewById(R.id.pointCounter);

        Qs = new ArrayList<>();
        Qs.add("If you could go anywhere in the world, where would you go?");
        Qs.add("If you were stranded on a desert island, what three things would you want to take with you?");
        Qs.add("If you could eat only one food for the rest of your life, what would that be?");
        Qs.add("If you won a million dollars, what is the first thing you would buy?");
        Qs.add("If you could spaned the day with one fictional character, who would it be?");
        Qs.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onButtonClick (View view){

        TextView tv = (TextView)  this.findViewById(R.id.numberDisplay);
        EditText GuessInput = (EditText) findViewById(R.id.guessNumber);
        Random r = new Random();
        int number = r.nextInt(6)+1;
        tv.setText(Integer.toString(number));

        int number1= Integer.parseInt(GuessInput.getText().toString());

        if(number1<1 || number1>6 ){
            Toast.makeText(this,"invalid value", Toast.LENGTH_SHORT).show();
        }
        else if (number1 == number)
        {
            Toast.makeText(this,"Congrats!!", Toast.LENGTH_SHORT).show();
            int pointCounter = Integer.parseInt(PC.getText().toString());
            pointCounter = pointCounter +1;
            PC.setText(String.valueOf(pointCounter));
        }




    }
    public void roll_the_dice (View view){
        Random r = new Random ();
        int num = r.nextInt(6)+1;
        String question = Qs.get(num - 1);
        TextView tv = (TextView) findViewById(R.id.icebreaker);
        tv.setText(question);

    }
}
