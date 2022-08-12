package uk.aston.calculusldc.root.Database;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uk.aston.calculusldc.R;

//caches data and populates the RecyclerView with it
public class ScoreListAdapter extends RecyclerView.Adapter<ScoreListAdapter.ScoreViewHolder> implements Filterable
{
    private final LayoutInflater mInflater;

    private List<Score> mScoresList;

    private List<Score> mScoresListFull;

    private static ClickListener clickListener;


    public ScoreListAdapter(List<Score> mScores, Context context)
    {
        mInflater = LayoutInflater.from(context);

        this.mScoresList = mScores;


        mScoresListFull = new ArrayList<>(mScores);

    }



    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);


        return new ScoreViewHolder(itemView);

    }

    public void setOnItemClickListener(ClickListener clickListener)
    {
        ScoreListAdapter.clickListener = clickListener;
    }

    public interface ClickListener
    {
        void onItemClick(View v, int position);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position)
    {
        if (mScoresList != null)
        {
            Score current = mScoresList.get(position);

            holder.topicNameItemView.setText(current.getmTopic());


            holder.scoreValueItemView.setText(""+current.getMscore());

        } else
            {
            // Covers the case of data not being ready yet.
            holder.topicNameItemView.setText("No Journey");
        }

    }



    public void setmScoresList(List<Score> scores)
    {
        mScoresList = scores;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount()
    {
        if (mScoresList != null)
            return mScoresList.size();
        else return 0;
    }

    public Score getScoreAtPosition(int position)
    {
        return mScoresList.get(position);
    }


    class ScoreViewHolder extends RecyclerView.ViewHolder
    {
        private final TableLayout scoreItem;
        private final TextView topicNameItemView;
        private final TextView scoreValueItemView;



        private ScoreViewHolder(View itemView)
        {
            super(itemView);
            scoreItem = itemView.findViewById(R.id.textView);
            topicNameItemView = itemView.findViewById(R.id.textTopicName);
            scoreValueItemView = itemView.findViewById(R.id.textScore);


            Log.i("ADAPTER", topicNameItemView.toString());
        }
    }


    @Override
    public Filter getFilter() {
        return scoreFilter;
    }

    private final Filter scoreFilter = new Filter()
    {
        @Override
        protected FilterResults performFiltering(CharSequence searchFilter)
        {

            List<Score> filteredScoreList = new ArrayList<>();

            //if the input field is empty
            if (searchFilter == null || searchFilter.length() == 0)
            {
                filteredScoreList.addAll(mScoresListFull);
            } else
                {
                //format filter so it is not case sensitive and there are no spaces
                String stringFilter = searchFilter.toString().toLowerCase().trim();

                //Loop through each journey in journey list
                for (Score score : mScoresListFull) {
                    if (score.getmTopic().toLowerCase().contains(stringFilter)) {
                        filteredScoreList.add(score);
                    }
                }
            }


            FilterResults results = new FilterResults();
            results.values = filteredScoreList;

            //filtered array list is now passed as results to publishResults method
            return results;
        }

        //Publishes results to the UI thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results)
        {
            //Remove all items in this list because we only want items from our filtered list in it
            mScoresList.clear();
            mScoresList.addAll((List) results.values);

            //Tells adapter it has to refresh its list
            notifyDataSetChanged();

        }
    };


}
