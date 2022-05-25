package uk.aston.calculusldc.root.integration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agog.mathdisplay.MTMathView;

import uk.aston.calculusldc.R;


public class IntegrationByPartialFracFragment extends Fragment {

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

        mExampleView = view.findViewById(R.id.integrationPartial);
        mExampleView.setLatex("$ \\int \\frac{7x + 25}{x^2 + 7x + 12}dx $");
        mExampleView.setFontSize(39);

        mExampleView2 = view.findViewById(R.id.integrationPartial2);
        mExampleView2.setLatex("$ \\int \\frac{7x + 25}{x^2 + 7x + 12}dx = \\int \\frac{4}{x + 3} + \\frac{3}{x + 4}dx $");
        mExampleView2.setFontSize(40);

        mExampleView3 = view.findViewById(R.id.integrationPartial3);
        mExampleView3.setLatex("$ =\\int \\frac{4}{x + 3} dx + \\int \\frac{3}{x + 4}dx = 4ln|x+3| + 3ln|x+4| + C $");
        mExampleView3.setFontSize(40);
//
//        mExampleView4 = view.findViewById(R.id.integrationParts4);
//        mExampleView4.setLatex("$ u(x) = x \\, and \\, \\frac{dv(x)}{dx} = e^x,   $");
//        mExampleView4.setFontSize(40);
//
//        mExampleView5 = view.findViewById(R.id.integrationParts5);
//        mExampleView5.setLatex("$ \\frac{du(x)}{dx} = 1 \\, and \\, v(x) = \\int e^xdx = e^x,  $");
//        mExampleView5.setFontSize(40);
//
//        mExampleView5 = view.findViewById(R.id.integrationParts6);
//        mExampleView5.setLatex("$ \\int_{-2}^2 xe^xdx = {[xe^x - e^x]_{-2}}^2 = (2e^2 - e^2) - ((-2)e^{-2} - e^{-2}) = e^2 + 3e^{-2}  $");
//        mExampleView5.setFontSize(36);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_integration_by_partial_frac, container, false);
    }
}