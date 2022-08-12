package uk.aston.calculusldc.root.InteractiveDiagrams;

import android.content.Intent;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.differentiation.SavedFragment;

public class InteractiveDiagramCalculatorActivity extends AppCompatActivity {

    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;
    LinearLayout layout5;
    LinearLayout layout6;

    LinearLayout numbersLayout;
    ImageButton infoButton;
    TextView infoText;

    private TextView screen;
    private String screenGraphFormula = "";
    private int length = 1000;
    public String[] expression = new String[length];
    private int same = 0;
    private int deg = 0;
    private int inv = 0;
    private int hyp = 0;
    private int index = -1;
    private int typingNumber = 0;
    private int parenthesisOpen = 0;
    private int parenthesisClosed = 0;
    private int bracketsToClose =0;
    public final static String EXTRA_FUNCTION = "uk.aston.calculusldc.root.InteractiveDiagrams.00";
    public final static String EXTRA_LENGTH = "uk.aston.calculusldc.root.InteractiveDiagrams.01";
    public final static String EXTRA_DEG = "uk.aston.calculusldc.root.InteractiveDiagrams.02";



    // The long click of the delete button is initialized
    public View.OnLongClickListener longClick = new View.OnLongClickListener()
    {
        @Override
        public boolean onLongClick(View v) {
            index = -1;
            typingNumber = 0;
            parenthesisOpen = 0;
            parenthesisClosed = 0;
            same = 0;
            screenGraphFormula = "y=";
            screen.setText(screenGraphFormula);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        screen = (TextView) findViewById(R.id.formulaView);
        layout1 = findViewById(R.id.column1);
        layout2 = findViewById(R.id.column2);
        layout3 = findViewById(R.id.column3);
        layout4 = findViewById(R.id.column4);
        layout5 = findViewById(R.id.column5);
        layout6 = findViewById(R.id.column6);
        screen = findViewById(R.id.formulaView);
        numbersLayout = findViewById(R.id.numbers);
        infoButton = findViewById(R.id.infoButton);
        infoText = findViewById(R.id.infoText);


        screen.setMovementMethod(new ScrollingMovementMethod());
        Button canc = (Button) findViewById(R.id.canc);
        if(savedInstanceState!=null){
            expression =savedInstanceState.getStringArray("Espressione");
            typingNumber =savedInstanceState.getInt("Digit");
            parenthesisOpen =savedInstanceState.getInt("Aperta");
            parenthesisClosed =savedInstanceState.getInt("Chiusa");
            index=savedInstanceState.getInt("Index");
        }
        screenGraphFormula = "y=";
        for (int i = 0; i <= index; i++) {
            screenGraphFormula = screenGraphFormula + expression[i];
        }
        screen.setText(screenGraphFormula);
        canc.setOnLongClickListener(longClick);


        BottomNavigationView navView = findViewById(R.id.nav);

        navView.setSelectedItemId(R.id.graphCalculateFragment);

        // Perform item selected listener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {

                    case R.id.graphCalculateFragment:

                        startActivity(new Intent(getApplicationContext(), InteractiveDiagramCalculatorActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.savedFragment:

                        Fragment savedFragment = new SavedFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                        transaction.replace(R.id.activity_graph_main, savedFragment);
                        transaction.addToBackStack(null);
                        layout1.setVisibility(View.GONE);
                        layout2.setVisibility(View.GONE);
                        layout3.setVisibility(View.GONE);
                        layout4.setVisibility(View.GONE);
                        layout5.setVisibility(View.GONE);
                        layout6.setVisibility(View.GONE);
                        screen.setVisibility(View.GONE);
                        numbersLayout.setBackgroundColor(0);
                        infoButton.setVisibility(View.GONE);
                        infoText.setVisibility(View.GONE);


                        transaction.commit();
                        return true;
                    case R.id.homeFragment:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putStringArray("Espressione", expression);
        savedInstanceState.putInt("Digit", typingNumber);
        savedInstanceState.putInt("Aperta", parenthesisOpen);
        savedInstanceState.putInt("Chiusa", parenthesisClosed);
        savedInstanceState.putInt("Index",index);




        super.onSaveInstanceState(savedInstanceState);
    }
    public void startCalculator (View view){
        finish();
    }

    public void enterKeyboardNumber(View v)
    {
        Button button = (Button) v;

        // in case it precedes a constant
        if(index>=0) {
            if (expression[index] == "e" || expression[index] == "x" || expression[index] == "π" ||
                    expression[index] == ")" || expression[index] == "!") {
                index++;
                expression[index] = "*";
                typingNumber = 0;
                parenthesisClosed =0;
            }
        }

        // in case the result is still on screen
        if (parenthesisClosed == 0) {
            if (same == 1) {
                index--;
                same = 0;
                typingNumber = 0;
            }}

        // insert number
        if (typingNumber == 0) {
            index++;
            expression[index] = button.getText().toString();
            typingNumber = 1;
        } else {
            expression[index] = expression[index] + button.getText().toString();
        }

            //display on screen
            screenGraphFormula = "y=";
            for (int i = 0; i <= index; i++) {
                screenGraphFormula = screenGraphFormula + expression[i];
            }
            parenthesisOpen = 0;
            screen.setText(screenGraphFormula);


    }
    public void entryOperandFromKeyboard(View v) {
        Button button = (Button) v;

        if (typingNumber == 1 && parenthesisOpen == 0) {
            screenGraphFormula = button.getText().toString();
            index++;
            if (screenGraphFormula.equals("+")) expression[index] = "+";
            if (screenGraphFormula.equals("-")) expression[index] = "-";
            if (screenGraphFormula.equals("*")) expression[index] = "*";
            if (screenGraphFormula.equals("/")) expression[index] = "/";
            if (screenGraphFormula.equals("^")) expression[index] = "^";
            typingNumber = 0;
            if (screenGraphFormula.equals("!")) {
                expression[index] = "!";
                typingNumber = 1;
            }
            parenthesisOpen = 0;
            parenthesisClosed = 0;
        } else if (typingNumber == 0) {
            screenGraphFormula = button.getText().toString();
            if (screenGraphFormula.equals("-")) {
                index++;
                expression[index] = "-";
                typingNumber = 1;
            }

        }

        screenGraphFormula = "y=";
        for (int i = 0; i <= index; i++) {
            screenGraphFormula = screenGraphFormula + expression[i];
        }
        same = 0;
        screen.setText(screenGraphFormula);


    }
    public void enteringOpenParentheses(View v) {

        //if the result is still on the screen
        if (same == 1) {
            index--;
            same = 0;
            typingNumber = 0;
        }
        //to prevent having a negative index
        if(index==-1){
            index++;
            expression[index]="";
        }
        //Add * if needed
        boolean aNumberFollows=true;
        try{
            Double.parseDouble(expression[index]);
        }catch(NumberFormatException e){
            aNumberFollows=false;
        }
        if(aNumberFollows==true){
            index++;
            expression[index]="*";
            typingNumber =0;
        }
        if(expression[index]=="e" || expression[index]=="x" || expression[index]=="π"|| expression[index]==")" || expression[index] == "!"){
            index++;
            expression[index]="*";
            typingNumber =0;
        }

        //entering parentheses
        if(expression[index].length()>0){
            index++;
        }
        //to fix the null string bug

        expression[index] = "(";
        parenthesisOpen = 1;
        parenthesisClosed = 0;

        screenGraphFormula = "y=";
        for (int i = 0; i <= index; i++) {
            screenGraphFormula = screenGraphFormula + expression[i];
        }
        screen.setText(screenGraphFormula);

    }
    public void inputParenthesisClosed(View v) {

        if (typingNumber == 1 && same == 0 && parenthesisOpen == 0) {
            index++;
            expression[index] = ")";
            parenthesisOpen = 0;
            parenthesisClosed = 1;
        }
        screenGraphFormula = "y=";
        for (int i = 0; i <= index; i++) {
            screenGraphFormula = screenGraphFormula + expression[i];
        }
        screen.setText(screenGraphFormula);
    }
    public void inputXAndConstants(View v) {
        Button button = (Button) v;
        if (same == 1) {
            index--;
            same = 0;
            typingNumber = 0;
        }
        //to prevent having a negative index
        if(index==-1){
            index++;
            expression[index]="";
        }

        if(index>=0){
            boolean aNumberFollows=true;
            try{
                Double.parseDouble(expression[index]);
            }catch(NumberFormatException e){
                aNumberFollows=false;
            }
            if(aNumberFollows==true){
                index++;
                expression[index]="*";
            }
            if(expression[index]=="e" || expression[index]=="x" || expression[index]=="π"||
                    expression[index]==")" || expression[index] == "!"){
                index++;
                expression[index]="*";
            }
        }

        if(expression[index].length()>0){
            index++;
        }

        screenGraphFormula = button.getText().toString();
        if (screenGraphFormula.equals("π")) expression[index] = "π";
        if (screenGraphFormula.equals("e")) expression[index] = "e";
        if (screenGraphFormula.equals("x")) expression[index] = "x";

        same =0;
        typingNumber =1;
        parenthesisOpen =0;
        screenGraphFormula = "y=";
        for (int i = 0; i <= index; i++) {
            screenGraphFormula = screenGraphFormula + expression[i];
        }
        screen.setText(screenGraphFormula);
    }
    //input By operating
    public void inputUnaryOperand(View v) {
        Button button = (Button) v;
        if (same == 1) {
            index--;
            same = 0;
            typingNumber = 0;
        }
        if(index==-1){
            index++;
            expression[index]="";
        }
        //addition *
        boolean aNumberFollows=true;
        try{
            Double.parseDouble(expression[index]);
        }catch(NumberFormatException e){
            aNumberFollows=false;
        }
        if(aNumberFollows==true){
            index++;
            expression[index]="*";
            typingNumber =0;
        }
        if(expression[index]=="e" || expression[index]=="x" || expression[index]=="π"| expression[index]==")"){
            index++;
            expression[index]="*";
            typingNumber =0;
        }


        screenGraphFormula = button.getText().toString();
        if(expression[index].length()>0){
            index++;
        }
        if (screenGraphFormula.equals("sin")) expression[index] = "sin";
        if (screenGraphFormula.equals("cos")) expression[index] = "cos";
        if (screenGraphFormula.equals("tan")) expression[index] = "tan";
        if (screenGraphFormula.equals("erf")) expression[index] = "erf";
        if (screenGraphFormula.equals("asin")) expression[index] = "asin";
        if (screenGraphFormula.equals("acos")) expression[index] = "acos";
        if (screenGraphFormula.equals("atan")) expression[index] = "atan";
        if (screenGraphFormula.equals("inverf")) expression[index] = "inverf";
        if (screenGraphFormula.equals("sinh")) expression[index] = "sinh";
        if (screenGraphFormula.equals("cosh")) expression[index] = "cosh";
        if (screenGraphFormula.equals("tanh")) expression[index] = "tanh";
        if (screenGraphFormula.equals("asinh")) expression[index] = "asinh";
        if (screenGraphFormula.equals("acosh")) expression[index] = "acosh";
        if (screenGraphFormula.equals("atanh")) expression[index] = "atanh";
        if (screenGraphFormula.equals("√")) expression[index] = "√";
        if (screenGraphFormula.equals("abs")) expression[index] = "Abs";
        if (screenGraphFormula.equals("log")) expression[index] = "log";
        if (screenGraphFormula.equals("ln")) expression[index] = "ln";
        if (screenGraphFormula.equals("sgn")) expression[index] = "sgn";
        if (screenGraphFormula.equals("inverf")) expression[index] = "inverf";
        typingNumber =0;
        enteringOpenParentheses(v);



        screenGraphFormula = "y=";
        for (int i = 0; i <= index; i++) {
            screenGraphFormula = screenGraphFormula + expression[i];
        }
        screen.setText(screenGraphFormula);
    }

    public void delete(View v) {

        Button button = (Button) v;

        button.setOnLongClickListener(longClick);

        if (index >= 0) {
            if (typingNumber == 1) {
                if (expression[index].length() >= 1)
                    if (expression[index] == "!") {
                        expression[index] = "";
                        index--;
                        if (expression[index] == ")") {
                            parenthesisClosed = 1;
                        }
                    } else
                    if(expression[index] != "ans") expression[index] = expression[index].substring(0, expression[index].length() - 1);
                    else expression[index]="";
                else {
                    index--;
                    typingNumber = 0;
                    if (index >= 0) {
                        if (expression[index] == "(") {
                            parenthesisOpen = 1;
                            parenthesisClosed = 0;
                        }
                    }

                }
                screenGraphFormula = "y=";
                for (int i = 0; i <= index; i++) {
                    screenGraphFormula = screenGraphFormula + expression[i];
                }
                screen.setText(screenGraphFormula);
            }
        }
        if (index >= 0) {
            if (typingNumber == 0 || parenthesisOpen == 1 || parenthesisClosed == 1) {
                if (expression[index] != "(") typingNumber = 1;
                expression[index] = "";
                index--;

                if (index >= 0) {
                    if (expression[index] == "(") {
                        parenthesisOpen = 1;
                        parenthesisClosed = 0;
                    } else if (expression[index] == ")") {
                        parenthesisOpen = 0;
                        parenthesisClosed = 1;
                    } else {
                        parenthesisOpen = 0;
                        parenthesisClosed = 0;
                    }
                }
                if(index>=0){
                    if (expression[index] == "sin" || expression[index] == "asin" || expression[index] == "sinh" || expression[index] == "asinh" ||
                            expression[index] == "cos" || expression[index] == "acos" || expression[index] == "cosh" || expression[index] == "acosh" ||
                            expression[index] == "tan" || expression[index] == "atan" || expression[index] == "tanh" || expression[index] == "atanh" ||
                            expression[index] == "erf" || expression[index] == "inverf" || expression[index] == "√" || expression[index] == "abs" ||
                            expression[index] == "log" || expression[index] == "ln" ||  expression[index] == "Abs" ||  expression[index] == "sgn") {
                        expression[index] = "";
                        index--;

                    }
                }
                screenGraphFormula = "y=";
                for (int i = 0; i <= index; i++) {
                    screenGraphFormula = screenGraphFormula + expression[i];
                }
                screen.setText(screenGraphFormula);
            }
        }
        if(index>=0){
            if(expression[index].length()==0){
                index--;
                typingNumber =0;
            }
        }


        if (same == 1) {
            index = -1;
            typingNumber = 0;
            parenthesisOpen = 0;
            parenthesisClosed = 0;
            same = 0;
            screenGraphFormula = "y=";
            screen.setText(screenGraphFormula);
        }


    }



    public void inverse(View view) {
        Button button = (Button) view;

        Button button1 = (Button) findViewById(R.id.sin);
        Button button2 = (Button) findViewById(R.id.cos);
        Button button3 = (Button) findViewById(R.id.tan);
        Button button4 = (Button) findViewById(R.id.erf);
        if (inv == 0) {
            if (hyp == 0) {
                button1.setText("asin");
                button2.setText("acos");
                button3.setText("atan");
            } else {
                button1.setText("asinh");
                button2.setText("acosh");
                button3.setText("atanh");
            }
            button4.setText("inverf");
            inv = 1;
            button.setTextColor(getResources().getColor(R.color.orange, getTheme()));
        } else {
            if (hyp == 0) {
                button1.setText("sin");
                button2.setText("cos");
                button3.setText("tan");
            } else {
                button1.setText("sinh");
                button2.setText("cosh");
                button3.setText("tanh");
            }
            button4.setText("erf");
            inv = 0;
            button.setTextColor(getResources().getColor(R.color.white, getTheme()));
        }


    }
    public void hyperbolic(View view) {
        Button button = (Button) view;
        Button button1 = (Button) findViewById(R.id.sin);
        Button button2 = (Button) findViewById(R.id.cos);
        Button button3 = (Button) findViewById(R.id.tan);
        if (hyp == 0) {
            if (inv == 0) {
                button1.setText("sinh");
                button2.setText("cosh");
                button3.setText("tanh");
            } else {
                button1.setText("asinh");
                button2.setText("acosh");
                button3.setText("atanh");
            }
            hyp = 1;
            button.setTextColor(getResources().getColor(R.color.orange, getTheme()));
        } else {
            if (inv == 0) {
                button1.setText("sin");
                button2.setText("cos");
                button3.setText("tan");
            } else {
                button1.setText("asin");
                button2.setText("acos");
                button3.setText("atan");
            }
            hyp = 0;
            button.setTextColor(getResources().getColor(R.color.white, getTheme()));
        }


    }

    public void calculatorToDiagram(View view){
     //eliminate excess operators (syntax check)
        if(index>=0){
            while(expression[index].equals("+") || expression[index].equals("-") || expression[index].equals("*") ||
                    expression[index].equals("/") || expression[index].equals("^")){
                index--;
            }}

        //Parenthesis control
        for(int i=0; i<=index; i++) {


            if (expression[i] == "(") {
                bracketsToClose++;

            }
            if (expression[i] == ")") {
                bracketsToClose--;
            }
        }
        for(int i = 0; i< bracketsToClose; i++){
            index++;
            expression[index]=")";
        } //the brackets have been closed

        //refresh screen
        screenGraphFormula = "y=";
        for (int i = 0; i <= index; i++) {
            screenGraphFormula = screenGraphFormula + expression[i];
        }
        screen.setText(screenGraphFormula);

        String[] tempExpression = new String[length];

        //Constant substitution
        tempExpression= Function.replaceConstantsWithJavaCode(0.0, expression,index+1);

        //Syntax check
        if(bracketsToClose >=0){
        try {

            Function.createGraphicValues(10,tempExpression,index+1,-10,10,deg);

            Intent intent = new Intent(this, InteractiveDiagramActivity.class);
            intent.putExtra(EXTRA_FUNCTION, tempExpression);
            intent.putExtra(EXTRA_LENGTH, index);
            intent.putExtra(EXTRA_DEG, deg);
            startActivity(intent);

        } catch (NumberFormatException e) {
        screenGraphFormula = "Syntax Error: Enter an equation first";
        screen.setText(screenGraphFormula);
    } catch (ArrayIndexOutOfBoundsException e) {
        screenGraphFormula = "Syntax Error: Enter an equation first";
        screen.setText(screenGraphFormula);
    }}else{
            screenGraphFormula = "Syntax Error: Enter an equation first";
            screen.setText(screenGraphFormula);
        }
        bracketsToClose =0;
    }


}
