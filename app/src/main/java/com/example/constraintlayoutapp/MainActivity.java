package com.example.constraintlayoutapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    public static int counter = 0;
    public static List<Integer> imagesList = new ArrayList<Integer>();

    public MainActivity () {
        imagesList.add(R.drawable.bootstrap_logo);
        imagesList.add(R.drawable.ic_launcher_background);
        imagesList.add(R.drawable.jquery_logo);
        imagesList.add(R.drawable.popper_logo);
        imagesList.add(R.drawable.webpack_logo);
        imagesList.add(R.drawable.wordpress_logo);
    }

//    permet de sauvegarder des données en cas de changement d'activité
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("counter", counter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        sauvegarde des données en cas de changement d'activité sinon commence une nouvelle activité
        if (savedInstanceState != null) {

            int value = savedInstanceState.getInt("MY_FIELD");

            // ... update your views


        } else {
            // no previous state, start fresh
        }

        Button resetButton = (Button) findViewById(R.id.reset_button);
        TextView counterTextView = (TextView) findViewById(R.id.counter);

        resetButton.setOnClickListener(view -> {
            counter = 0;
            counterTextView.setText(String.valueOf(counter));
        });

        Button countButton = (Button) findViewById(R.id.count_button);

//        click event on countButton
        countButton.setOnClickListener(view -> {
            counterTextView.setText(String.valueOf(++counter));
            Toast.makeText(MainActivity.this, String.valueOf(counter), Toast.LENGTH_SHORT).show();
        });

//        long click event on countButton
        countButton.setOnLongClickListener(view -> {
            counterTextView.setText(String.valueOf(++counter));
            return true;
        });

        ImageView image = (ImageView) findViewById(R.id.image);

//        click event on image
        image.setOnClickListener(view -> {
            int position = (int) (Math.random() * 5);
            image.setImageResource(imagesList.get(position));
            Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();

        });

        RadioGroup radioGroupColors = (RadioGroup) findViewById(R.id.radioGroupColors);

//        choose a radiobutton in a radiogroup click event
        radioGroupColors.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checkedRadioButton = (RadioButton) findViewById(group.getCheckedRadioButtonId());
            Toast.makeText(this, checkedRadioButton.getText().toString(), Toast.LENGTH_SHORT).show();
        });

        CheckBox checkBoxProduire = (CheckBox) findViewById(R.id.produire);

//        verify if the checkbox is checked or not
        checkBoxProduire.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) checkBoxProduire.setText("Vous êtes productif !");
            else checkBoxProduire.setText("Produire");
        });

        CheckBox checkBoxProfiter = (CheckBox) findViewById(R.id.profiter);

//        verify if the checkbox is checked or not
        checkBoxProfiter.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) checkBoxProfiter.setText("Vous profitez !");
            else checkBoxProfiter.setText("Profiter");
        });



        Button nextButton = (Button) findViewById(R.id.next_button);

//        click event on nextButton
        nextButton.setOnClickListener(view -> {
            //        se diriger vers une autre activité
            Intent nextActivity = new Intent(this, NextActivity.class);
            nextActivity.putExtra("counter", counter);
            startActivityForResult(nextActivity, 1);
        });

    }

}