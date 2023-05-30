package com.prakash.temperatureconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    ArrayAdapter ad;
    Button convertButton;
    Spinner toTemperature,fromTemperature;
    EditText inputTemperature;
    TextView solutionTextView;
    String[] units;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toTemperature = findViewById(R.id.toTemperature);
        fromTemperature= findViewById(R.id.fromTemperature);
        inputTemperature = findViewById(R.id.input_temperature);
        solutionTextView = findViewById(R.id.solution_Textview);
        convertButton = findViewById(R.id.convert_button);
        units = new String[]{"Celsius", "Fahrenheit", "Kelvin", "Rankine"};

    }

    @Override
    protected void onStart() {
        super.onStart();

         ad = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item,units);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toTemperature.setAdapter(ad);
        fromTemperature.setAdapter(ad);


    }

    @Override
    protected void onResume() {
        super.onResume();

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String celsiusSymbol = " °C";
                String fahrenheitSymbol= " °F";
                String rankineSymbol = " °R";
                String kelvinSymbol = " K";
                String temperatureStr = inputTemperature.getText().toString();

                if(!temperatureStr.isEmpty()) {

                    double input_temp = Double.valueOf(temperatureStr);

                    String fromTempStr = fromTemperature.getSelectedItem().toString();


                    String toTempStr = toTemperature.getSelectedItem().toString();


                    if(fromTempStr.equals("Celsius"))
                    {

                        if(toTempStr.equals("Fahrenheit"))
                        {

                            double fah = (input_temp*((double)9/5) + 32);
                            solutionTextView.setText(""+fah+fahrenheitSymbol);
                        }
                        else if(toTempStr.equals("Kelvin"))
                        {
                            double kelvin = input_temp + 273.15;
                            solutionTextView.setText(""+kelvin+kelvinSymbol);
                        }
                        else if(toTempStr.equals("Rankine"))
                        {
                            double Rankine = (input_temp + 273.15) * (double)9/5;
                            solutionTextView.setText(""+Rankine+rankineSymbol);
                        }
                        else if(toTempStr.equals("Celsius"))
                        {
                            solutionTextView.setText(""+input_temp+celsiusSymbol);
                        }
                    }
                    else if(fromTempStr.equals("Fahrenheit"))
                    {
                        if(toTempStr.equals("Celsius"))
                        {
                            double cel = (input_temp - 32 )*(double)5/9;
                            solutionTextView.setText(""+cel+celsiusSymbol);
                        }
                        else if(toTempStr.equals("Kelvin"))
                        {

                            double kelvin = (input_temp + 459.67) * (double)5/9;
                            solutionTextView.setText(""+kelvin+kelvinSymbol);

                        }
                        else if(toTempStr.equals("Rankine"))
                        {
                            double rankine = input_temp + 459.67;
                            solutionTextView.setText(""+rankine+rankineSymbol);
                        }
                        else if(toTempStr.equals("Fahrenheit")) {

                            solutionTextView.setText(""+input_temp+fahrenheitSymbol);
                        }

                    }
                    else if(fromTempStr.equals("Kelvin"))
                    {
                        if(toTempStr.equals("Celsius"))
                        {

                            double celsius = input_temp - 273.15;
                            solutionTextView.setText(""+celsius+celsiusSymbol);
                        }
                        else if(toTempStr.equals("Fahrenheit")) {

                            double fahrenheit = (input_temp *((double)9 / 5) - 459.67);
                            solutionTextView.setText(""+fahrenheit+fahrenheitSymbol);
                        }
                        else if(toTempStr.equals("Rankine"))
                        {
                            double rankine = input_temp * ((double)9 / 5);
                            solutionTextView.setText(""+rankine+rankineSymbol);
                        }

                        else if(toTempStr.equals("Kelvin"))
                        {

                            solutionTextView.setText(""+input_temp+kelvinSymbol);
                        }

                    }

                    else if(fromTempStr.equals("Rankine"))
                    {
                        if(toTempStr.equals("Celsius"))
                        {

                          double celsius  =  ((input_temp - 491.67) * 5/(double)9);
                          solutionTextView.setText(""+celsius+celsiusSymbol);
                        }
                        else if(toTempStr.equals("Fahrenheit")) {

                            double fahrenheit = input_temp - 459.67;
                            solutionTextView.setText(""+fahrenheit+fahrenheitSymbol);
                        }

                        else if(toTempStr.equals("Kelvin"))
                        {

                            double kelvin = input_temp * ((double)5 / 9);
                            solutionTextView.setText(""+kelvin+kelvinSymbol);
                        }

                        else if(toTempStr.equals("Rankine"))
                        {
                            solutionTextView.setText(""+input_temp+rankineSymbol);
                        }

                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please Enter a Valid Temperature ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}