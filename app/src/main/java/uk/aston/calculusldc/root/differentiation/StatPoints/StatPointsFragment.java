package uk.aston.calculusldc.root.differentiation.StatPoints;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import uk.aston.calculusldc.R;


public class StatPointsFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stat_points, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button playVidButton = view.findViewById(R.id.vidButtonStatPoints);

        //play quiz once button is pressed
        playVidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), StatPointsVidActivity.class);
                startActivity(intent);

            }
        });

        Button playButton = view.findViewById(R.id.playButtonStatPoints);

        //play quiz once button is pressed
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), StatPointsQuestionActivity.class);
                startActivity(intent);

            }
        });
    }
}