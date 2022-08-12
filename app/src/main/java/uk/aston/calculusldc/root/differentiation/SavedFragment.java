package uk.aston.calculusldc.root.differentiation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.Database.Score;
import uk.aston.calculusldc.root.Database.ScoreListAdapter;
import uk.aston.calculusldc.root.Database.ScoreViewModel;

//Aggregates the Score, ScoreViewModel & ScoreListAdapter classes to display the completed tasks
public class SavedFragment extends Fragment {


    private ScoreViewModel mScoreViewModel;


    ScoreListAdapter adapter;
    private List<Score> mScores;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_saved, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mScores = new ArrayList<>();

        //Set up recylerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new ScoreListAdapter(mScores, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        for(int i = 0; i < recyclerView.getChildCount(); i++)
        {
            mScores.add(adapter.getScoreAtPosition(i));
        }

        //Set up score view model
        mScoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);


        // Get all the journeys from the database
        // and associate them to the adapter.
        mScoreViewModel.getAllScores().observe(getActivity(), new Observer<List<Score>>()
        {
            @Override
            public void onChanged(@Nullable final List<Score> scores)
            {
                // Cached copy of the scores updated in the adapter.
                adapter.setmScoresList(scores);
            }
        });


    }
}
