package uk.aston.calculusldc.root.Database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

//provides data to the UI
public class ScoreViewModel extends AndroidViewModel
{
    private final ScoreRepository mRepository;

    private final LiveData<List<Score>> mAllScores;

    public ScoreViewModel(Application application)
    {
        super(application);
        mRepository = new ScoreRepository(application);
        mAllScores = mRepository.getmAllScores();
    }

    public LiveData<List<Score>> getAllScores() { return mAllScores; }

    //wrapper insert method hides the repositories insert method from the UI
    public void insert(Score score) { mRepository.insert(score); }

    public void update(Score score)
    {
        mRepository.update(score);
    }

}
