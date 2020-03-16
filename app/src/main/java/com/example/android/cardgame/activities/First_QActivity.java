package com.example.android.cardgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.cardgame.R;
import com.example.android.cardgame.Utilities;

public class First_QActivity extends AppCompatActivity implements View.OnClickListener {
    Button confirm_first;
    ImageView back_img1;
    private RadioGroup radioGroup_first_question;
    RadioButton radioButton;
    private RadioButton rb_one, rb_two, rb_three, rb_four;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__q);
        findViews();
    }

    private void findViews() {
        confirm_first = (Button) findViewById(R.id.confirm_first);
        confirm_first.setOnClickListener(this);

        back_img1 = (ImageView) findViewById(R.id.back_img1);
        back_img1.setOnClickListener(this);

        radioGroup_first_question = (RadioGroup) findViewById(R.id.radioGroup_first_question);
        rb_one = (RadioButton) findViewById(R.id.rb_one);
        rb_two = (RadioButton) findViewById(R.id.rb_two);
        rb_three = (RadioButton) findViewById(R.id.rb_three);
        rb_four = (RadioButton) findViewById(R.id.rb_four);

        backup();
    }

    private void backup() {
        if (Utilities.First_Ans != null) {
            switch (Utilities.First_Ans) {
                case "Conakry":
                    rb_one.setChecked(true);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Prague":
                    rb_one.setChecked(false);
                    rb_two.setChecked(true);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Helsinki":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(true);
                    rb_four.setChecked(false);
                    break;

                case "None of the above":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.confirm_first:
                // get selected radio button from radioGroup
                int selectedId = radioGroup_first_question.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                try {
                    if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                        Utilities.First_Ans = radioButton.getText().toString();
                        Intent tosecond = new Intent(First_QActivity.this, Second_QActivity.class);
                        startActivity(tosecond);
                        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.back_img1:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                finish();
                break;

        }
    }
}