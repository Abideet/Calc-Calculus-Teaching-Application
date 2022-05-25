package uk.aston.calculusldc.root.integration;

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


public class IntegrationFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_integration, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Buttons for main diff menu
        Button introIntButton = view.findViewById(R.id.introduction_to_integration);

        introIntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(IntegrationFragment.this).navigate(R.id.action_integrationFragment_to_introToIntegrationFragment);
            }
        });

        Button IntSubButton = view.findViewById(R.id.integration_by_substitution);

        IntSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(IntegrationFragment.this).navigate(R.id.action_integrationFragment_to_intregrationBySubstitutionFragment);
            }
        });

        Button IntPartsButton = view.findViewById(R.id.integration_by_parts);

        IntPartsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(IntegrationFragment.this).navigate(R.id.action_integrationFragment_to_integrationByPartsFragment);
            }
        });

        Button IntPartialFracButton = view.findViewById(R.id.integration_with_partial_fractions);

        IntPartialFracButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(IntegrationFragment.this).navigate(R.id.action_integrationFragment_to_integrationByPartialFracFragment);
            }
        });
//
//        Button chainRuleButton = view.findViewById(R.id.chain_rule);
//
//        chainRuleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(IntegrationFragment.this).navigate(R.id.action_differentiationFragment_to_chainRuleFragment);
//            }
//        });


    }

}