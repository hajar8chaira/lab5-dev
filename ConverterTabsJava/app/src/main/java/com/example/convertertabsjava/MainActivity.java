package com.example.convertertabsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout navigationTabs;
    private ViewPager2 zoneContenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison avec les IDs du fichier XML
        navigationTabs = findViewById(R.id.barre_onglets);
        zoneContenu = findViewById(R.id.contenu_pager);

        // Configuration de l'adaptateur
        SectionsPagerAdapter monGestionnaire = new SectionsPagerAdapter(this);
        zoneContenu.setAdapter(monGestionnaire);

        // Liaison Onglets <-> ViewPager
        new TabLayoutMediator(navigationTabs, zoneContenu, (tab, position) -> {
            tab.setText(position == 0 ? "TEMPÉRATURE" : "DISTANCE");
        }).attach();
    }

    @Override
    public void onBackPressed() {
        // Boîte de dialogue de confirmation
        new AlertDialog.Builder(this)
                .setTitle("Quitter")
                .setMessage("Voulez-vous vraiment fermer l'application ?")
                .setPositiveButton("Oui", (dialog, which) -> {
                    // Fermeture propre de l'activité
                    MainActivity.super.onBackPressed();
                    finish();
                })
                .setNegativeButton("Annuler", null)
                .show();
    }
}
