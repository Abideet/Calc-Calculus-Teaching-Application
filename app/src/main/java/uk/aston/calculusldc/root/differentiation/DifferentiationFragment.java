package uk.aston.calculusldc.root.differentiation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import uk.aston.calculusldc.R;


public class DifferentiationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_differentiation, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Buttons for main diff menu
        Button introDiffButton = view.findViewById(R.id.intro_to_diff);

        introDiffButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_introToDifferentiationFragment);
            }
        });

        Button varFuncDiffButton = view.findViewById(R.id.diff_of_various_func);

        varFuncDiffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_variousFunctionsDifFragment);
            }
        });

        Button secDerivButton = view.findViewById(R.id.second_deriv_and_higher_deriv);

        secDerivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_secondDerivFragment);
            }
        });

        Button statPButton = view.findViewById(R.id.stat_points);

        statPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_statPointsFragment);
            }
        });

        Button chainRuleButton = view.findViewById(R.id.chain_rule);

        chainRuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_chainRuleFragment);
            }
        });

        Button proRuleButton = view.findViewById(R.id.product_rule);

        proRuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_productRuleFragment);
            }
        });

        Button quoRuleButton = view.findViewById(R.id.quotient_rule);

        quoRuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_quotientRuleFragment);
            }
        });

        Button implicitDiffButton = view.findViewById(R.id.implicit_diff);

        implicitDiffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_implicitDiffFragment);
            }
        });

        Button parDiffButton = view.findViewById(R.id.partial_diff);

        parDiffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DifferentiationFragment.this).navigate(R.id.action_differentiationFragment_to_partialDiffFragment);
            }
        });








    }
}