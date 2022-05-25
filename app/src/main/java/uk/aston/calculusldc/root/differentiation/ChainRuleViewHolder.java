//package uk.aston.calculusldc.screens.differentiation;
//
//import android.app.Application;
//import android.view.View;
//import android.widget.Adapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.exoplayer2.SimpleExoPlayer;
//import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
//import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
//import com.google.android.exoplayer2.trackselection.TrackSelector;
//import com.google.android.exoplayer2.ui.PlayerView;
//import com.google.android.exoplayer2.upstream.BandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
//
//import uk.aston.calculusldc.R;
//
//public class ChainRuleViewHolder extends RecyclerView.ViewHolder {
//
//
//    View mView;
//    //TODO -- rename all variables
//    SimpleExoPlayer ePlayer;
//    private PlayerView mExPlayerView;
//
//
//
//
//    public ChainRuleViewHolder(@NonNull View itemView) {
//        super(itemView);
//
//        mView = itemView;
//    }
//
//    public void setVideo(final Application app, String title, final String url){
//
//        TextView mTextView = mView.findViewById(R.id.Titletv);
//
//        mExPlayerView = mView.findViewById(R.id.exoplayer_view);
//
//        mTextView.setText(title);
//        //try catch to retrieve videos
//        //try {
//
//            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(app).build();
//            //selects tracks for the players renderers
//            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()); //actual parameter is .Factory(bandwidthMeter) but shows error
//
//            //exoPlayer = (SimpleExoPlayer)ExoPlayerFactory.newSimpleInstance(app);
//
//        //}catch ()
//
//
//
//    }
//
//}
