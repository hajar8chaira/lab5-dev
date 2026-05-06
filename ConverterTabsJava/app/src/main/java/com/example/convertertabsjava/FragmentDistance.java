package com.example.convertertabsjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDistance extends Fragment {
    public FragmentDistance() { super(R.layout.fragment_dist); }

    @Override
    public void onViewCreated(@NonNull View vue, @Nullable Bundle savedInstanceState) {
        EditText champInput = vue.findViewById(R.id.champ_saisie_dist);
        RadioButton optKmToMiles = vue.findViewById(R.id.radio_k_m);
        TextView txtResultat = vue.findViewById(R.id.label_resultat_dist);
        Button btnOk = vue.findViewById(R.id.bouton_action_dist);

        btnOk.setOnClickListener(v -> {
            String texteSaisi = champInput.getText().toString();
            if (texteSaisi.isEmpty()) {
                Toast.makeText(getContext(), "Entrez une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double valeur = Double.parseDouble(texteSaisi);
            double resultatFinal;

            if (optKmToMiles.isChecked()) {
                resultatFinal = valeur * 0.621371;
            } else {
                resultatFinal = valeur / 0.621371;
            }

            txtResultat.setText(String.format("%.2f", resultatFinal));
        });
    }
}
