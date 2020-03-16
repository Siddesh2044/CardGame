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

public class Third_QActivity extends AppCompatActivity implements View.OnClickListener {

    private Button confirm_third;
    private ImageView back;
    private RadioGroup radioGroup_third_question;
    RadioButton radioButton;

    private RadioButton rb_one, rb_two, rb_three, rb_four;
    private ImageView back_img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third__q);
        findViews();
    }

    private void findViews() {
        confirm_third = (Button) findViewById(R.id.confirm_third);
        confirm_third.setOnClickListener(this);

        back_img3 = (ImageView) findViewById(R.id.back_img3);
        back_img3.setOnClickListener(this);

        radioGroup_third_question = (RadioGroup) findViewById(R.id.radioGroup_third_question);
        rb_one = (RadioButton) findViewById(R.id.rb_one);
        rb_two = (RadioButton) findViewById(R.id.rb_two);
        rb_three = (RadioButton) findViewById(R.id.rb_three);
        rb_four = (RadioButton) findViewById(R.id.rb_four);

        backup();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.confirm_third:
                // get selected radio button from radioGroup
                int selectedId = radioGroup_third_question.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                try {
                    if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {

                        Intent tofourth = new Intent(Third_QActivity.this, Fourth_QActivity.class);
                        startActivity(tofourth);
                        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);

                        Utilities.Third_Ans = radioButton.getText().toString();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.back_img3:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                finish();
                break;

        }
    }

    private void backup() {
        if (Utilities.Third_Ans != null) {
            switch (Utilities.Third_Ans) {
                case "Monaco":
                    rb_one.setChecked(true);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Abuja":
                    rb_one.setChecked(false);
                    rb_two.setChecked(true);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Podgorica":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(true);
                    rb_four.setChecked(false);
                    break;

                case "Kampala":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(true);
                    break;
            }
        }
    }

}
