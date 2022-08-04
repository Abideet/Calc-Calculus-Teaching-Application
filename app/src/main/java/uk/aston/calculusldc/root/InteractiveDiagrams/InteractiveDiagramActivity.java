package uk.aston.calculusldc.root.InteractiveDiagrams;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.differentiation.SavedFragment;

public class InteractiveDiagramActivity extends AppCompatActivity {

    int samples = 1300;
    double minX = -8.1;
    double maxX = 8.1;
    String[] espressione;
    int deg, length;
    double[] function;
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_visual);

        //The intent is captured and the necessary variables initialized
        Intent intent = getIntent();
        espressione = intent.getStringArrayExtra(InteractiveDiagramCalculatorActivity.EXTRA_FUNCTION);
        deg = intent.getIntExtra(InteractiveDiagramCalculatorActivity.EXTRA_DEG,0);
        length = intent.getIntExtra(InteractiveDiagramCalculatorActivity.EXTRA_LENGTH,0)+1;
        String[] tempEspressione = makeTheFunctionReadable(espressione,length);

        //The function values are generated
        function = Function.createGraphicValues(samples, tempEspressione, length, minX, maxX, deg);

        //Graph defined
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        DataPoint[] dati = new DataPoint[samples];

        //The series that will be drawn by the chart is generated
        for (int i = 0; i < samples; i++) {

        //Problematic values are discarded
            if(   Double.isInfinite(function[i])==false &&
                    Double.isNaN(function[i])==false &&
                    function[i]<=1000000000 &&
                    function[i]>=-1000000000){
                series.appendData(new DataPoint(minX+i*(maxX-minX)/(samples-1), function[i]), true, samples);
            }
        }
        //The graph settings are set
        series.setThickness(4);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinX(minX);
        graph.getViewport().setMaxX(maxX);
        graph.getViewport().setMaxY(series.getHighestValueY());
        graph.getViewport().setMinY(series.getLowestValueY());
        graph.getViewport().setScalable(true);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollableY(true);
        graph.addSeries(series);

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

                        transaction.replace(R.id.activity_graph_visual, savedFragment);
                        transaction.addToBackStack(null);
                        graph.setVisibility(View.GONE);
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


    public String[] makeTheFunctionReadable(String[] expression, int length){

        for(int i=0;i<length;i++){
            if (expression[i].equals("+")) expression[i]="+";
            if (expression[i].equals("-")) expression[i]="-";
            if (expression[i].equals("*")) expression[i]="*";
            if (expression[i].equals("/")) expression[i]="/";
            if (expression[i].equals("^")) expression[i]="^";
            if (expression[i].equals("!")) expression[i]="!";
            if (expression[i].equals("(")) expression[i]="(";
            if (expression[i].equals(")")) expression[i]=")";
            if (expression[i].equals("sin")) expression[i]="sin";
            if (expression[i].equals("cos")) expression[i]="cos";
            if (expression[i].equals("tan")) expression[i]="tan";
            if (expression[i].equals("asin")) expression[i]="asin";
            if (expression[i].equals("acos")) expression[i]="acos";
            if (expression[i].equals("atan")) expression[i]="atan";
            if (expression[i].equals("sinh")) expression[i]="sinh";
            if (expression[i].equals("cosh")) expression[i]="cosh";
            if (expression[i].equals("tanh")) expression[i]="tanh";
            if (expression[i].equals("asinh")) expression[i]="asinh";
            if (expression[i].equals("acosh")) expression[i]="acosh";
            if (expression[i].equals("atanh")) expression[i]="atanh";
            if (expression[i].equals("log")) expression[i]="log";
            if (expression[i].equals("ln")) expression[i]="ln";
            if (expression[i].equals("Abs")) expression[i]="Abs";
            if (expression[i].equals("sgn")) expression[i]="sgn";
            if (expression[i].equals("erf")) expression[i]="erf";
            if (expression[i].equals("inverf")) expression[i]="inverf";
            if (expression[i].equals("√")) expression[i]="√";
            if (expression[i].equals("e")) expression[i]="e";
            if (expression[i].equals("π")) expression[i]="π";
            if (expression[i].equals("x")) expression[i]="x";
        }
        return expression;
    }

}