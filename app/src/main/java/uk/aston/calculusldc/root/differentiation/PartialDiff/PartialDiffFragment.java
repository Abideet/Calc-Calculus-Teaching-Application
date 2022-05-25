package uk.aston.calculusldc.root.differentiation.PartialDiff;

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


public class PartialDiffFragment extends Fragment {


    public PartialDiffFragment() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_partial_diff, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button playVidButton = view.findViewById(R.id.vidButtonsPartialDiff);

        //play quiz once button is pressed
        playVidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //NavHostFragment.findNavController(ChainRuleFragment.this).navigate(R.id.action_chainRuleFragment_to_startChainRuleQuizFragment);
                Intent intent = new Intent(getActivity(), PartialDiffVidActivity.class);
                startActivity(intent);

            }
        });
    }
}