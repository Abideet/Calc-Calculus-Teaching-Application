package uk.aston.calculusldc.root.integration.IntegrationBySubstitution;

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


public class IntregrationBySubstitutionFragment extends Fragment {

    MTMathView mExampleView;
    MTMathView mExampleView2;
    MTMathView mExampleView3;
    MTMathView mExampleView4;
    MTMathView mExampleView5;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mExampleView = view.findViewById(R.id.integrationSub);
        mExampleView.setLatex("$ \\frac{d}{dx}(f(u(x))) = \\frac{df(u(x))}{du(x)} \\cdot \\frac{du(x)}{dx} \\Rightarrow \\int \\frac{df(u(x))}{du(x)} \\cdot \\frac{du(x)}{dx} = f(u(x)).  $");
        mExampleView.setFontSize(39);

        mExampleView2 = view.findViewById(R.id.integrationSub2);
        mExampleView2.setLatex("$ \\frac{df(u(x))}{du(x)} = 2u^2 = 2(x + 2)^2,  $");
        mExampleView2.setFontSize(40);

        mExampleView3 = view.findViewById(R.id.integrationSub3);
        mExampleView3.setLatex("$ \\int 2(x + 2)^2 dx = \\int 2u^2 \\cdot 1dx = \\int \\frac{df(u(x))}{du(x)} \\cdot \\frac{du(x)}{dx} =  f(u(x)),  $");
        mExampleView3.setFontSize(40);

        mExampleView4 = view.findViewById(R.id.integrationSub4);
        mExampleView4.setLatex("$ f(u(x)) = \\int \\frac{df(u(x))}{du(x)} \\cdot \\frac{du(x)}{dx} du(x) =  \\int 2u^2du = 2\\frac{u^3}{3} + C = \\frac{2(x+2)^3}{3} + C  $");
        mExampleView4.setFontSize(33);

        mExampleView5 = view.findViewById(R.id.integrationSub5);
        mExampleView5.setLatex("$ f(u(x)) = \\int 2(x+2)^2{2} dx = \\frac{2(x+2)^3}{3} + C.  $");
        mExampleView5.setFontSize(40);


        Button playVidButton = view.findViewById(R.id.vidButtonsIntBySubstitution);

        //play quiz once button is pressed
        playVidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), IntegrationBySubstitutionVidActivity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intregration_by_substitution, container, false);
    }
}