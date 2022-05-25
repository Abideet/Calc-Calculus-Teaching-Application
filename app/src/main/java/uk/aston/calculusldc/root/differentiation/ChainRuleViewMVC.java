package uk.aston.calculusldc.root.differentiation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.aston.calculusldc.R;

public class ChainRuleViewMVC {

    private final View rootView;

    public ChainRuleViewMVC(LayoutInflater inflater, ViewGroup parent){
         rootView = inflater.inflate(R.layout.fragment_chain_rule, parent);
    }


    public View getRootView() {
        return rootView;
    }

}
