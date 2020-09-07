package com.bmicalculator;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button buttonCalculate, buttonExit;
    EditText inputKg, inputM;
    TextView showResult, showBMI, showImpBMI;
    private double kg, m;
    private DecimalFormat TWO_DECIMAL_PLACES = new DecimalFormat(".##");
    MetricFormula metricFormula; ImperialFormula imperialFormula;
    BMICategory bmiCategory = new BMICategory();
    private int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonExit = findViewById(R.id.buttonExit);
        inputKg = findViewById(R.id.inputKg);
        inputM = findViewById(R.id.inputM);
        showResult = findViewById(R.id.showResult);
        showBMI = findViewById(R.id.showBMI);
        showImpBMI = findViewById(R.id.showImpBMI);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kgs = inputKg.getText().toString();
                String ms = inputM.getText().toString();
                if(kgs.isEmpty()) {
                    kg = 0;
                } else {
                    kg = Double.parseDouble(kgs);
                }
                if(ms.isEmpty()) {
                    m = 0;
                } else {
                    m = Double.parseDouble(ms);
                }

                metricFormula = new MetricFormula(kg, m);
                imperialFormula = new ImperialFormula(kg, m);
                alertDialog();

            }
            private void alertDialog() {
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                String msg = "";
                if(metricFormula.getInputKg() <= 0) {
                    msg = "Please enter valid weight";
                } else if(metricFormula.getInputM() <= 0) {
                    msg = "Please enter valid height";
                } else {
                    double bmi = metricFormula.computeBMI(metricFormula.getInputKg(), metricFormula.getInputM());
                    msg = "BMI = " + String.valueOf(TWO_DECIMAL_PLACES.format(bmi));
                    msg = msg + "\n" + bmiCategory.getCategory(bmi);
                    msg = msg + "\n\nSUGGESTIONS:";
                    msg = msg + "\n" + bmiCategory.getSuggestions(bmi);
                }
                dialog.setMessage(msg);
                dialog.setTitle("BMI Report");
                dialog.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                //Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                            }
                        });
                dialog.setNegativeButton("Close",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"cancel is clicked",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alertDialog=dialog.create();
                alertDialog.show();
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
