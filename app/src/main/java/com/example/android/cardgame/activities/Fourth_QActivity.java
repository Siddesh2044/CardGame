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

public class Fourth_QActivity extends AppCompatActivity implements View.OnClickListener {

    private Button confirm_fourth;
    private ImageView back;
    private ImageView back_img4;
    private RadioGroup radioGroup_fourt_question;
    RadioButton radioButton;

    private RadioButton rb_one, rb_two, rb_three, rb_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth__q);

        findViews();
    }

    private void findViews() {
        confirm_fourth = (Button) findViewById(R.id.confirm_fourth);
        confirm_fourth.setOnClickListener(this);

        back_img4 = (ImageView) findViewById(R.id.back_img4);
        back_img4.setOnClickListener(this);

        radioGroup_fourt_question = (RadioGroup) findViewById(R.id.radioGroup_fourt_question);
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
            case R.id.confirm_fourth:
                // get selected radio button from radioGroup
                int selectedId = radioGroup_fourt_question.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                try {
                    if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                        Intent tofifth = new Intent(Fourth_QActivity.this, Fifth_QActivity.class);
                        startActivity(tofifth);
                        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);

                        Utilities.Fourth_Ans = radioButton.getText().toString();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.back_img4:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                finish();
                break;
        }
    }

    private void backup() {
        if (Utilities.Fourth_Ans != null) {
            switch (Utilities.Fourth_Ans) {
                case "Havana":
                    rb_one.setChecked(true);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Santiago":
                    rb_one.setChecked(false);
                    rb_two.setChecked(true);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Beijing":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(true);
                    rb_four.setChecked(false);
                    break;

                case "Gaborone":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(true);
                    break;
            }
        }
    }

}

