package com.training.lfallon.viewspart2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title;
    private TextView counterTextView;
//    private Button buttonIncrementCounter;
    private View buttonIncrementCounter; //can get away with this if button only ever used for click events. adds more flexibility down road
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = (TextView)findViewById(R.id.activity_main_counter);
        buttonIncrementCounter = (Button)findViewById(R.id.activity_main_incrementCounterButton);

//        buttonIncrementCounter.setOnClickListener(this); //(1) implement OnClickListener in Activity
//        buttonIncrementCounter.setOnClickListener(new ButtonClickHAndler()); //(2) create an inner class that implements OnClickListener

        //(3) anonymous inner class
        buttonIncrementCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                counterTextView.setText(count + "");
            }
        });
    }

    @Override
    public void onClick(View v) {

        //main buttonIncrementCounter click
        if(v.getId() == R.id.activity_main_incrementCounterButton){
            count++;
            counterTextView.setText(count + "");
        }
    }

    //need to watch for memory leaks. garbage collector may not be able to manage since
    //this is an inner class and contains an automatic reference to the parent class (MainActivity.java in this case) that instantiated it
    private class ButtonClickHAndler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            count++;
            counterTextView.setText(count + "");
        }
    }
}
