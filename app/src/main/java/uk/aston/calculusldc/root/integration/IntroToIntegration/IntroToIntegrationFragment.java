package uk.aston.calculusldc.root.integration.IntroToIntegration;

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


public class IntroToIntegrationFragment extends Fragment {

    private MTMathView mExampleView;
    private MTMathView mExampleView2;



    public IntroToIntegrationFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mExampleView = view.findViewById(R.id.integration);
        mExampleView.setLatex("$ G(t) = \\int g(t)dt  $");
        mExampleView.setFontSize(70);

        mExampleView2 = view.findViewById(R.id.integration2);
        mExampleView2.setLatex("$ \\frac{d}{dt} (G(t)) = g(t)  $");
        mExampleView2.setFontSize(70);

        Button playVidButton = view.findViewById(R.id.vidButtonsIntroToIntegration);

        //play quiz once button is pressed
        playVidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), IntroToIntegrationVidActivity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_intro_to_integration, container, false);
    }
}