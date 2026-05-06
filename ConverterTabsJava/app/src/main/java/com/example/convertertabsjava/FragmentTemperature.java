package com.example.convertertabsjava;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTemperature extends Fragment {
    public FragmentTemperature() { super(R.layout.fragment_temp); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        EditText champSaisie = view.findViewById(R.id.edit_valeur_temp);
        RadioButton optCtoF = view.findViewById(R.id.radio_c_to_f);
        TextView labelResultat = view.findViewById(R.id.text_result_temp);

        view.findViewById(R.id.btn_convert_temp).setOnClickListener(v -> {
            String texte = champSaisie.getText().toString();
            if (!texte.isEmpty()) {
                double val = Double.parseDouble(texte);
                double calcul = optCtoF.isChecked() ? (val * 9/5) + 32 : (val - 32) * 5/9;
                labelResultat.setText(String.format("%.2f", calcul));
            }
        });
    }
}
