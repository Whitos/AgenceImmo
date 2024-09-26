package com.example.agenceimmo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agenceimmo.databinding.ActivityDetailsppartementBinding;
import com.example.agenceimmo.databinding.ActivityMainBinding;

public class DetailsppartementActivity extends AppCompatActivity {
    private ActivityDetailsppartementBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsppartementBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        String rue = intent.getStringExtra("rue");
        String ville = intent.getStringExtra("ville");
        String codePostal = intent.getStringExtra("codePostal");
        String etage = intent.getStringExtra("etage");
        boolean ascenseur = intent.getBooleanExtra("ascenseur", false);

        StringBuilder details = new StringBuilder();
        details.append("Rue : ").append(rue).append("\n");
        details.append("Ville : ").append(ville).append("\n");
        details.append("Code postal : ").append(codePostal).append("\n");
        details.append("Étage : ").append(etage).append("\n");
        details.append("Ascenseur : ").append(ascenseur ? "Oui" : "Non");


        binding.textViewDetails.setText(details.toString());

    }
}