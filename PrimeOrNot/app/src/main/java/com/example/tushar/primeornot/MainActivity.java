package com.example.tushar.primeornot;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int number;
    private final static String statusField = "Status field value";
    private final static String numField = "Number field value";
    RelativeLayout mrelativelayout ;

    Boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Prime Or Not");
        TextView txtview = (TextView) findViewById(R.id.textView);
        mrelativelayout = (RelativeLayout)findViewById(R.id.relativelayout);

        if(savedInstanceState == null)
        {
            number = generateRandomNumbers();
            txtview.setText("Is the number "+number + " prime ?");
        }

        else
        {
            number = savedInstanceState.getInt(numField);
            status = savedInstanceState.getBoolean(statusField);
            txtview.setText("Is the number "+number + " prime ?");
        }

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

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState)
    {
        saveInstanceState.putInt(numField,number);
        saveInstanceState.putBoolean(statusField,status);

        super.onSaveInstanceState(saveInstanceState);
    }

    public int generateRandomNumbers()
    {
        Random r = new Random();
        return r.nextInt(1000);
    }

    public Boolean primeOrNot()
    {
        int root = (int)Math.sqrt(number);

        for(int i = 2; i <= root; i++)
        {
            if(number % i == 0)
            {
                return false;
            }
        }

        return true;
    }

    public void generateQuestion(View v)
    {

        if(status == false)
        {
            Toast.makeText(this,"Please answer the question",Toast.LENGTH_SHORT).show();
            return;
        }
        mrelativelayout.setBackgroundColor(Color.WHITE);
        TextView txtview = (TextView) findViewById(R.id.textView);
        number = generateRandomNumbers();
        txtview.setText("Is the number "+number + " prime ?");
        status = false;


    }
    public void checkAnswer(View v) {

        Boolean value = primeOrNot();


    switch(v.getId())
    {
        case R.id.correctAnswer :
                                    if(status == true)
                                    {
                                        Toast.makeText(this,"Please try the next question",Toast.LENGTH_SHORT).show();

                                    }
                                    if(value == true && status == false)
                                    {
                                        status = true;
                                        mrelativelayout.setBackgroundColor(Color.rgb(00,64,00));
                                        Toast.makeText(this,"Congratulation,this is correct",Toast.LENGTH_SHORT).show();

                                    }

                                    else if(value == false && status == false)
                                    {
                                        status = true;
                                        mrelativelayout.setBackgroundColor(Color.rgb(80,00,00));
                                        Toast.makeText(this,"Sorry,this is wrong",Toast.LENGTH_SHORT).show();

                                    }



                                    break;

        case R.id.incorrectAnswer :

                                     if(status == true)
                                    {

                                       Toast.makeText(this,"Please try the next question",Toast.LENGTH_SHORT).show();

                                    }

                                    if(value == false && status == false)
                                    {
                                        status = true;
                                        mrelativelayout.setBackgroundColor(Color.rgb(00,64,00));
                                        Toast.makeText(this,"Congratulation,this is correct",Toast.LENGTH_SHORT).show();

                                    }


                                    else if(value == true && status == false )
                                    {
                                        status = true;
                                        mrelativelayout.setBackgroundColor(Color.rgb(80,00,00));
                                        Toast.makeText(this,"Sorry,this is wrong",Toast.LENGTH_SHORT).show();
                                    }


                                    break;

        case R.id.next :
                            break;


    }

}
}
