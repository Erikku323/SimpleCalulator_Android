package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  TextView NumOutput;
    private TextView EquationView;

    //Initiate For Number Buttons
    private Button One_Button;
    private Button Two_Button;
    private Button Three_Button;
    private Button Four_Button;
    private Button Five_Button;
    private Button Six_Button;
    private Button Seven_Button;
    private Button Eight_Button;
    private Button Nine_Button;
    private Button Zero_Button;

    private Button CE_Button;
    private Button C_Button;
    private Button Plus_Button;
    private Button Equal_Button;
    private Button Subtract_Button;
    private Button Multiply_Button;
    private Button Division_Button;

    private Button Neg_Button;
    private Button Power2_Button;


    //Initiate for Operation Buttons




    //  List<Integer> ValueList = new ArrayList<>();
    //  int ValueIndex= 0;

    int OperationType = 0;
    // 0 = none Selected
    // 1 = Addition
    // 2 = Subtraction
    // 3 = Multiplication
    // 4 = Division


    double sum;

    double  Value1 = 0;
    double Value2;
    boolean NewVal = false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NumOutput = (TextView) findViewById(R.id.NumOutput);
        EquationView = (TextView) findViewById(R.id.EquationView);
        One_Button = (Button) findViewById(R.id.One_Button);
        Two_Button = (Button) findViewById(R.id.Two_Button);
        Three_Button = (Button) findViewById(R.id.Three_Button);
        Four_Button = (Button) findViewById(R.id.Four_Button);
        Five_Button = (Button) findViewById(R.id.Five_Button);
        Six_Button = (Button) findViewById(R.id.Six_Button);
        Seven_Button = (Button) findViewById(R.id.Seven_Button);
        Eight_Button = (Button) findViewById(R.id.Eight_Button);
        Nine_Button = (Button) findViewById(R.id.Nine_Button);
        Zero_Button = (Button) findViewById(R.id.Zero_Button);

        CE_Button = (Button) findViewById(R.id.CE_Button);
        C_Button = (Button) findViewById(R.id.C_Button);

        Plus_Button = (Button) findViewById(R.id.Plus_Button);
        Subtract_Button = (Button) findViewById(R.id.Subtract_Button);
        Multiply_Button = (Button) findViewById(R.id.Multiply_Button);
        Division_Button = (Button) findViewById(R.id.Division_Button);
        Equal_Button = (Button) findViewById(R.id.Equal_Button);
        Neg_Button = (Button) findViewById(R.id.Neg_Button);
        Power2_Button = (Button)findViewById(R.id.Power2_Button);




        EquationView.setText("");
        NumOutput.setText("0");



        // set listeners
        One_Button.setOnClickListener(OneButtonClick);
        Two_Button.setOnClickListener(TwoButtonClick);
        Three_Button.setOnClickListener(ThreeButtonClick);
        Four_Button.setOnClickListener(FourButtonClick);
        Five_Button.setOnClickListener(FiveButtonClick);
        Six_Button.setOnClickListener(SixButtonClick);
        Seven_Button.setOnClickListener(SevenButtonClick);
        Eight_Button.setOnClickListener(EightButtonClick);
        Nine_Button.setOnClickListener(NineButtonClick);
        Zero_Button.setOnClickListener(ZeroButtonClick);

        CE_Button.setOnClickListener(CEButtonClick);
        C_Button.setOnClickListener(CButtonClick);
        Equal_Button.setOnClickListener(EqualsClick);
        Plus_Button.setOnClickListener(PlusClick);
        Subtract_Button.setOnClickListener(SubTrackButtonClick);
        Multiply_Button.setOnClickListener(MultiplyButtonClick);
        Division_Button.setOnClickListener(DivisionButtonClick);
        Neg_Button.setOnClickListener((NegButtonClick));
        Power2_Button.setOnClickListener(Power2Click);



    }

    View.OnClickListener OneButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("1");
        }
    };

    View.OnClickListener TwoButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("2");
        }
    };

    View.OnClickListener ThreeButtonClick   = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // NumOutput.append("3");
            ModifyOutputTxt("3");


        }
    };

    View.OnClickListener FourButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("4");
        }
    };

    View.OnClickListener FiveButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("5");
        }
    };

    View.OnClickListener SixButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("6");
        }
    };

    View.OnClickListener SevenButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("7");
        }
    };

    View.OnClickListener EightButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("8");
        }
    };

    View.OnClickListener NineButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("9");

        }
    };

    View.OnClickListener ZeroButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ModifyOutputTxt("0");
        }
    };

    View.OnClickListener CEButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("I am CLicking");
            NumOutput.setText("0");
            NewVal = true;
            EquationView.setText(" ");
            System.out.println("CE BUTTON CLICKED");
        }
    };

    View.OnClickListener CButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            NumOutput.setText("0");
        }
    };







    View.OnClickListener EqualsClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            String Val1String;
            String Val2String;
            String SumString;
            switch (OperationType){

                case 0:
                    //do nothing for now
                    break;

                case 1: //Addiction
                    System.out.println("Value is " + Value1);
                    Value2 = Double.valueOf(NumOutput.getText().toString());
                    sum = Value1 + Value2;


                     Val1String = ModifyValue(Value1);
                     Val2String = ModifyValue(Value2);
                    SumString = ModifyValue(sum);
                    EquationView.setText(Val1String + " + " + Val2String + " = " + SumString);
                    System.out.println(" Value 1 is  " + Val1String);
                    NumOutput.setText(SumString);
                    NewVal = true;
                    break;

                case 2 : // Subtraction
                    Value2 = Double.valueOf(NumOutput.getText().toString());
                    sum = Value1 - Value2;

                     Val1String = ModifyValue(Value1);
                     Val2String = ModifyValue(Value2);
                     SumString = ModifyValue(sum);
                    EquationView.setText(Val1String + " - " + Val2String + " = " + SumString) ;
                    NumOutput.setText(SumString);
                    NewVal = true;
                    break;

                case 3 : // Multiplication
                    Value2 = Double.valueOf(NumOutput.getText().toString());
                    sum = Value1 * Value2;
                    Val1String = ModifyValue(Value1);
                    Val2String = ModifyValue(Value2);
                    SumString = ModifyValue(sum);
                    EquationView.setText(Val1String + " x " + Val2String + " = " + SumString) ;
                    NumOutput.setText(SumString);
                    NewVal = true;
                    break;

                case 4 : // Division
                    Value2 = Double.valueOf(NumOutput.getText().toString());
                    sum = Value1 / Value2;
                    if((Double.isInfinite(sum) != true)){






                        Val1String = ModifyValue(Value1);
                        Val2String = ModifyValue(Value2);
                        SumString = ModifyValue(sum);

                        EquationView.setText(Val1String + " ÷ " + Val2String + " = " + SumString) ;
                        NumOutput.setText(SumString);
                    }else {
                        sum = 0;
                        System.out.println("Failed to divide");
                        EquationView.setText("Undefined");
                        NumOutput.setText("0");
                        NewVal = true;
                    }
                    break;


                default:
                    // do nothing
                    break;
            }

            // x System.out.println(NumOutput.getText());
        }
    };

    View.OnClickListener PlusClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {



           /* Value1 = Double.valueOf(NumOutput.getText().toString());
            if (isInteger(Value1) == true){
                DecimalFormat format = new DecimalFormat("0.#");
                Val1String = format.format(Value1);

            }else{
                Val1String = Double.valueOf(Value1).toString();


            }*/
            Value1 = Double.valueOf(NumOutput.getText().toString());
            String Val1String = ModifyValue(Double.valueOf(NumOutput.getText().toString()));

            OperationType = 1;
            EquationView.setText(Val1String + " + " );
            NewVal =  true;
            System.out.println("Value after Plus i is" + Value1);

        }
    };

    View.OnClickListener SubTrackButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Value1 = Double.valueOf(NumOutput.getText().toString());
            String Val1String = ModifyValue(Double.valueOf(NumOutput.getText().toString()));
            OperationType = 2;
            EquationView.setText(Val1String + " - " );
            NewVal =  true;
        }
    };

    View.OnClickListener MultiplyButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Value1 = Double.valueOf(NumOutput.getText().toString());

            String Val1String = ModifyValue(Double.valueOf(NumOutput.getText().toString()));
            OperationType = 3;
            EquationView.setText(Val1String + " X " );
            NewVal =  true;

        }
    };

    View.OnClickListener DivisionButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Value1 = Double.valueOf(NumOutput.getText().toString());
            String Val1String = ModifyValue(Double.valueOf(NumOutput.getText().toString()));
            OperationType = 4;
            EquationView.setText(Val1String + " ÷ " );
            NewVal =  true;
        }
    };

    View.OnClickListener NegButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            double NegVal = Double.valueOf(NumOutput.getText().toString());

            if(NegVal !=0) {
                NegVal = NegVal * -1;
                NumOutput.setText(ModifyValue(NegVal));
            }
        }
    };

    View.OnClickListener Power2Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            double powerVal = Double.valueOf(NumOutput.getText().toString());
            powerVal = Math.pow(powerVal,2);
            NumOutput.setText(ModifyValue(powerVal));

        }
    };




    public void ModifyOutputTxt(String Val){

        try{
            String OutputText =  NumOutput.getText().toString();
            if (Double.valueOf(OutputText) == 0 || (NewVal == true)){

                NumOutput.setText(Val);
                NewVal = false;

            } else if ((Double.valueOf(OutputText) == 0) && (Double.valueOf(Val) == 0)){

                // do nothing

            } else{

                NumOutput.append(Val);
            }


        }catch (NumberFormatException e){
            e.printStackTrace();
        }




    }

    public static boolean isInteger(double N)
    {

        // Convert double value
        // of N to integer
        int X = (int)N;
        double temp2 = N - X;

        // If N is not equivalent
        // to any integer
        if (temp2 > 0)
        {
            return false;
        }
        return true;
    }

   public static String ModifyValue(Double Value ) {


       String ValString;


       //Value = Double.valueOf(NumOutput.getText().toString());
       if (isInteger(Value) == true){
           DecimalFormat format = new DecimalFormat("0.#");
           ValString = format.format(Value);

       }else{
           ValString = Double.valueOf(Value).toString();


       }
       return ValString;



   }


   }

















