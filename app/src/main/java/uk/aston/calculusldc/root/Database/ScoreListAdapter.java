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

    // Cached copy of journeys that will be filtered
    private List<Score> mScoresList;

    // Copy of unfiltered list
    private List<Score> mScoresListFull;

    private static ClickListener clickListener;

    public ScoreListAdapter(Context context)
    {
        mInflater = LayoutInflater.from(context);
    }


    public ScoreListAdapter(List<Score> mScores, Context context)
    {
        mInflater = LayoutInflater.from(context);

        this.mScoresList = mScores;


        mScoresListFull = new ArrayList<>(mScores);

    }



    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        //change the layout later to one that better displays the journey
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

            //thought the parameter for setText was a reference to the xml e.g., findViewById(R.id.var)
            //without the "", setText gets a reference as Tony said
            //NOTE: Maybe thats why the recycler view value is 60 and += 4 everytime
            //69
            //73
            //74
            //went up to 76
            //maybe its storing the different runs and this is the list of the different runs

            //holder.topicNameItemView.setText(""+current.getJourneyID());

            //double distance = truncate(current.getMscore());

            holder.topicNameItemView.setText(current.getmTopic());


            holder.scoreValueItemView.setText(""+current.getMscore());

        } else
            {
            // Covers the case of data not being ready yet.
            holder.topicNameItemView.setText("No Journey");
        }

    }

    //Method to shorten distance to 2 decimal places
    static double truncate(double distance)
    {

        distance = distance * Math.pow(10, 2);
        distance = Math.floor(distance);
        distance = distance / Math.pow(10, 2);

        return distance;
    }



    public void setmScoresList(List<Score> scores)
    {
        mScoresList = scores;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
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
            //wordItemView = itemView.findViewById(R.id.textView);
            scoreItem = itemView.findViewById(R.id.textView);
            topicNameItemView = itemView.findViewById(R.id.textTopicName);
            scoreValueItemView = itemView.findViewById(R.id.textScore);


            //Click listener if you want button to take the user somewhere
//            itemView.setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View v)
//                {
//                    Log.d("clicked", "itemClicked");
//                    clickListener.onItemClick(v, getAdapterPosition());
//                }
//            });



            Log.i("ADAPTER", topicNameItemView.toString());
        }
    }

    public void filterList(ArrayList<Score> filteredList)
    {
        mScoresList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return journeyFilter;
    }

    private final Filter journeyFilter = new Filter()
    {
        @Override
        protected FilterResults performFiltering(CharSequence searchFilter)
        {

            List<Score> filteredScoreList = new ArrayList<>();

            //if the input field is empty
            if (searchFilter == null || searchFilter.length() == 0)
            {
                //Show all journeys in the list
                filteredScoreList.addAll(mScoresListFull);
            } else
                {
                //format filter so it is not case sensitive and there are no spaces
                String stringFilter = searchFilter.toString().toLowerCase().trim();

                //Loop through each journey in journey list
                for (Score score : mScoresListFull) {
                    //TODO: Change to journey name and allow user to set that
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
