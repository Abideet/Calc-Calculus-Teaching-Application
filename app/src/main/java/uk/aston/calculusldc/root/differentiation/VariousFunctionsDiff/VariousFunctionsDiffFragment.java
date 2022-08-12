package uk.aston.calculusldc.root.differentiation.VariousFunctionsDiff;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.agog.mathdisplay.MTMathView;

import uk.aston.calculusldc.R;


public class VariousFunctionsDiffFragment extends Fragment {

    MTMathView table;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_various_functions_dif, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        table = view.findViewById(R.id.table);

        table.setLatex("\\begin{bmatrix}\n" +
                "Function & Derivative  \\\\\n" +
                "constant & 0  \\\\\n" +
                "x^n & nx^{n-1} \\\\\n" +
                "sin(ax) & acos(ax)  \\\\\n" +
                "cos(ax) & -asin(ax)  \\\\\n" +
                "tan(ax) & -asec^2(ax)  \\\\\n" +
                "e^{ax} & ae^{ax}  \\\\\n" +
                "ln(ax) & \\frac{1}{x}  \\\\\n" +
                "\\end{bmatrix}");
        table.setFontSize(70);


        Button playVidButton = view.findViewById(R.id.vidButtonsVariousFunc);

        //play quiz once button is pressed
        playVidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), VariousFunctionsDiffVidActivity.class);
                startActivity(intent);

            }
        });

        Button playQuizButton = view.findViewById(R.id.playButtonVariousFunc);

        //play quiz once button is pressed
        playQuizButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), VariousFunctionsDiffQuestionActivity.class);
                startActivity(intent);

            }
        });

    }




}