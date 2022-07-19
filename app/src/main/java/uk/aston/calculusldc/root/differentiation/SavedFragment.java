package uk.aston.calculusldc.root.differentiation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
import uk.aston.calculusldc.root.differentiation.ChainRule.HighestScoreActivity;

public class SavedFragment extends Fragment {


    Button topicScore;
    EditText topic;
    TextView topicName;



    HighestScoreActivity chainRuleHighS = new HighestScoreActivity();


    private ScoreViewModel mScoreViewModel;

    Score score;

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

//        topicScore = view.findViewById(R.id.topicButton);
//        topic = view.findViewById(R.id.editTextTopic);
//        topicName = view.findViewById(R.id.topicNameView);

//        topicScore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String key = topic.getText().toString().trim();
//
//                SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//                //String value = HighestScoreActivity.getDefaults(key, getActivity());
//
//                //topicName.setText(value);
//
//                mPreferences.getString(getString(R.string.app_name), "");
//
//
//            }
//        });

        mScores = new ArrayList<>();

        //Set up recylerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new ScoreListAdapter(mScores, getActivity());
        //final JourneyListAdapter adapter = new JourneyListAdapter(view.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Could be used for feature to allow user to re attempt quiz
        //recyclerView.setClickable(true);


        for(int i = 0; i < recyclerView.getChildCount(); i++)
        {

            mScores.add(adapter.getScoreAtPosition(i));


        }

        //Set up score view model
        mScoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);


        // Get all the journeys from the database
        // and associate them to the adapter.
        //TODO - Update with lambda later
        mScoreViewModel.getAllJourneys().observe(getActivity(), new Observer<List<Score>>()
        {
            @Override
            public void onChanged(@Nullable final List<Score> scores)
            {
                // Update the cached copy of the journeys in the adapter.
                adapter.setmScoresList(scores);
            }
        });











    }
}
