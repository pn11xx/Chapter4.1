package com.example.planner.chapter41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView display = (TextView)findViewById(R.id.display);
        final EditText editText = (EditText)findViewById(R.id.editText);

        final String [] out = {" "};
        final String [] output = {""};

        Button factorialButton = (Button)findViewById(R.id.factorialButton);
        Button fibonacciButton = (Button)findViewById(R.id.fibonacciButton);
        Button oddsButton = (Button)findViewById(R.id.oddsButton);

        factorialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String input = editText.getText().toString();
                int factorial = 1;
                int n = Integer.parseInt(input);    //store user's input in n as an integer

                while(n>1) {
                    factorial = factorial*n; //4*3*2*1
                    n--;    //reduce by 1 each time and repeat the calculation until n<=1
                }
                out[0] = String.valueOf(factorial);
                display.setText(out[0]);    //Display the result in TextView 'display'
            }
        });

        fibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();//Convert user's input to String and store it in 'input'
                int n = Integer.parseInt(input);    //Convert 'input' to an integer and store it in 'n'
                Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();//Toast class prints messages in the app instead og the console
                int i=0;
                int previous = 0;
                int prePrevious = 0;
                int [] outs = new int[n];
                do {
                    if (i==1) {
                        previous = 1;
                    }
                    outs[i] = previous + prePrevious;
                    previous = outs[i];
                    if(i>0) {
                        prePrevious = outs[i - 1];
                    }
                    i++;
                }while(i<n);

                display.setText(Arrays.toString(outs));
            }
        });


        oddsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i , sum = 0;
                String input = editText.getText().toString();
                int n = Integer.parseInt(input);

                    for (i = 0; i <= n; i++){
                        if ( (i%2) == 1 ) {
                            sum += i;
                        }
                    }
                output[0] = String.valueOf(sum);
                display.setText(output[0]);

            }


        });


    }
}
