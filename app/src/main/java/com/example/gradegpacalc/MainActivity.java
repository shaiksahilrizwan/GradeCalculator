package com.example.gradegpacalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // declaring the necessary variables for handling the input
    private Spinner grade1;
    private Spinner credit1;
    private Spinner grade2;
    private Spinner credit2;
    private Spinner grade3;
    private Spinner credit3;
    private Spinner grade4;
    private Spinner credit4;
    private Spinner grade5;
    private Spinner credit5;
    private Spinner grade6;
    private Spinner credit6;
    private Spinner grade7;
    private Spinner credit7;
    //variable for TextView
    private TextView gpaShow;

    private double sumOfCredits=0.0;
    private double GPA = 0.0;
    private double numaratorGpaCred = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // instantiating the objects for the declared xml components
        credit1=(Spinner)findViewById(R.id.credits1);
        grade1=(Spinner)findViewById(R.id.grades1);
        credit2=(Spinner)findViewById(R.id.credits2);
        grade2=(Spinner)findViewById(R.id.grades2);
        credit3=(Spinner)findViewById(R.id.credits3);
        grade3=(Spinner)findViewById(R.id.grades3);
        credit4=(Spinner)findViewById(R.id.credits4);
        grade4=(Spinner)findViewById(R.id.grades4);
        credit5=(Spinner)findViewById(R.id.credits5);
        grade5=(Spinner)findViewById(R.id.grades5);
        credit6=(Spinner)findViewById(R.id.credits6);
        grade6=(Spinner)findViewById(R.id.grades6);
        credit7=(Spinner)findViewById(R.id.credits7);
        grade7=(Spinner)findViewById(R.id.grades7);
        gpaShow=(TextView) findViewById(R.id.gpaShower);
    }
    public void calcGPA(View view){
        // calculating the numerator part
        numaratorGpaCred+=getNumarator(grade1.getSelectedItem().toString(),credit1.getSelectedItem().toString())
        +getNumarator(grade2.getSelectedItem().toString(),credit2.getSelectedItem().toString())
                +getNumarator(grade3.getSelectedItem().toString(),credit3.getSelectedItem().toString())
        +getNumarator(grade4.getSelectedItem().toString(),credit4.getSelectedItem().toString())
        +getNumarator(grade5.getSelectedItem().toString(),credit5.getSelectedItem().toString())
        +getNumarator(grade6.getSelectedItem().toString(),credit6.getSelectedItem().toString())
        +getNumarator(grade7.getSelectedItem().toString(),credit7.getSelectedItem().toString());
        //no need of the bellow commented code
//    sumOfCredits=getCredVal(grade1.getSelectedItem().toString())
//            +getCredVal(grade2.getSelectedItem().toString())
//            +getCredVal(grade3.getSelectedItem().toString())
//            +getCredVal(grade4.getSelectedItem().toString())
//            +getCredVal(grade5.getSelectedItem().toString())
//            +getCredVal(grade6.getSelectedItem().toString())
//            +getCredVal(grade7.getSelectedItem().toString());
    GPA=numaratorGpaCred/sumOfCredits;
    String msgOutputString="";
    if(GPA>8.0 && GPA<9.0)
        msgOutputString="Your GPA is "+GPA+"\n Keep it Up Try for 9 !";
    else if(GPA>7.0 && GPA<8.0)
        msgOutputString="Your GPA is "+GPA+"\n You need to go Above the Average !";
    else if(GPA>9.0)
        msgOutputString="Your GPA is "+GPA+"\n Well that makes you Attendence Free? Keep it up!";
    else
        msgOutputString="Your GPA is "+GPA+"\n Improvement Needed Buddy! Keep Learning";
    gpaShow.setText(msgOutputString);
    GPA=0.0;
    numaratorGpaCred=0.0;
    sumOfCredits=0.0;
    }
    private double getNumarator(String grade,String credit){
            if(credit!="Credits"){
                double cred=getCredVal(credit);
                sumOfCredits+=cred; // as the grades and credits multiplied the credits are being added for denominator
                double grad=getGradeVal(grade);
                return cred*grad; // return the credit*grade value
            }else{
                return 0.0;
            }
    }
    private double getGradeVal(String grade){ // to get the appropriate grade double value
        switch(grade){
            case "S":
                return 10.0;
            case "A":
                return 9.0;
            case "B":
                return 8.0;
            case "C":
                return 7.0;
            case "D":
                return 6.0;
            case "E":
                return 5.0;
            default:
                return 0.0;

        }
    }
    private double getCredVal(String credit){ // to get appropriate credit double value
        switch(credit){
            case "0":
                return 0.0;
            case "1":
                return 1.0;
            case "2":
                return 2.0;
            case "3":
                return 3.0;
            case "4":
                return 4.0;
            case "6":
                return 6.0;
            default:
                return 0.0;

        }
    }
}