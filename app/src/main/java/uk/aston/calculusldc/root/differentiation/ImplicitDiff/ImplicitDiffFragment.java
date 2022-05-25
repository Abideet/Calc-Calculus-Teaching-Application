package uk.aston.calculusldc.root.differentiation.ImplicitDiff;

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


public class ImplicitDiffFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_implicit_diff, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button vidButton = view.findViewById(R.id.vidButtonsImplicitDiff);

        vidButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ImplicitDiffVidActivity.class);
                startActivity(intent);
            }
        });

        Button playButton = view.findViewById(R.id.playButtonImplicitDiff);

        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}
