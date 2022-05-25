package uk.aston.calculusldc.root.differentiation.ChainRule;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//import android.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import com.google.android.exoplayer2.ExoPlayer;
//import com.google.android.exoplayer2.SimpleExoPlayer;
//import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
//import com.google.android.exoplayer2.extractor.ExtractorsFactory;
//import com.google.android.exoplayer2.source.MediaSource;
//import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
//import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
//import com.google.android.exoplayer2.trackselection.TrackSelector;
//import com.google.android.exoplayer2.ui.PlayerView;
//import com.google.android.exoplayer2.upstream.BandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.agog.mathdisplay.MTMathView;

import uk.aston.calculusldc.R;


//diamond problem causing the
public class ChainRuleFragment extends Fragment
{

    private MTMathView mExampleView;



    public ChainRuleFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        return inflater.inflate(R.layout.fragment_chain_rule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);



        mExampleView = view.findViewById(R.id.example);
        mExampleView.setLatex("$ \\frac{dy}{dx} = \\frac{dy}{du} \\times \\frac{du}{dx} = 2u \\times cos(x) = 2sin(x)cos(x)  $");
        mExampleView.setFontSize(50);

        Button playQuizButton = view.findViewById(R.id.playButtonChainRule);

        //play quiz once button is pressed
        playQuizButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), QuizActivity.class);
                startActivity(intent);

            }
        });


        Button vidButton = view.findViewById(R.id.vidButtonsChainRule);

        //does not work and still diamond problem of needing to extend fragment and youtubeBaseActivity classes
        //-> so transition from this fragment to an activity instead of ChainRuleQuizFragment
//        vidButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(getActivity(), ChainRuleVidActivity.class);
//                startActivity(intent);
//            }
//        });

        vidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_chainRuleVidActivity);
            }
        });

    }
}