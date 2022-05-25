package uk.aston.calculusldc.root.integration.IntegrationByParts;

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


public class IntegrationByPartsFragment extends Fragment {

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

        mExampleView = view.findViewById(R.id.integrationParts);
        mExampleView.setLatex("$ \\int u(x) \\frac{dv(x)}{dx} dx = u(x)v(x) - \\int \\frac{du(x)}{dx} v(x)dx.  $");
        mExampleView.setFontSize(39);

        mExampleView2 = view.findViewById(R.id.integrationParts2);
        mExampleView2.setLatex("$ \\int_{-2}^2 xe^xdx $");
        mExampleView2.setFontSize(40);

        mExampleView3 = view.findViewById(R.id.integrationParts3);
        mExampleView3.setLatex("$ \\int xe^xdx  $");
        mExampleView3.setFontSize(40);

        mExampleView4 = view.findViewById(R.id.integrationParts4);
        mExampleView4.setLatex("$ u(x) = x \\, and \\, \\frac{dv(x)}{dx} = e^x,   $");
        mExampleView4.setFontSize(40);

        mExampleView5 = view.findViewById(R.id.integrationParts5);
        mExampleView5.setLatex("$ \\frac{du(x)}{dx} = 1 \\, and \\, v(x) = \\int e^xdx = e^x,  $");
        mExampleView5.setFontSize(40);

        mExampleView5 = view.findViewById(R.id.integrationParts6);
        mExampleView5.setLatex("$ \\int_{-2}^2 xe^xdx = {[xe^x - e^x]_{-2}}^2 = (2e^2 - e^2) - ((-2)e^{-2} - e^{-2}) = e^2 + 3e^{-2}  $");
        mExampleView5.setFontSize(36);


        Button playVidButton = view.findViewById(R.id.vidButtonsIntByParts);

        //play quiz once button is pressed
        playVidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), IntegrationByPartsVidActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_integration_by_parts, container, false);
    }
}