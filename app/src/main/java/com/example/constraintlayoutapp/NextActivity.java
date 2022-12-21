package com.example.constraintlayoutapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class NextActivity extends Activity {

    /**
     * {@inheritDoc}
     * <p>
     * Perform initialization of all fragments.
     *
     * @param savedInstanceState
     **/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

//        récupération des données de l'activité parente
        Bundle datas = getIntent().getExtras();
        int counter = datas.getInt("counter");

//        afficher le counter au changement d'activité
        TextView counterTextView = (TextView) findViewById(R.id.next_counter);
        counterTextView.setText(String.valueOf(counter));

        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> {
            Intent mainActivity = new Intent(this, MainActivity.class);
            startActivity(mainActivity);
        });
    }
}
