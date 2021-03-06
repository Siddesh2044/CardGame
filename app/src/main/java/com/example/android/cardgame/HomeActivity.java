package com.example.android.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.cardgame.activities.First_QActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout start_btn;
    TextView previous_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        findViews();
    }

    private void findViews() {
        start_btn = (LinearLayout) findViewById(R.id.start_btn);
        start_btn.setOnClickListener(this);

        previous_score = (TextView) findViewById(R.id.previous_score);

        if(Utilities.Result_btn_click){
            previous_score.setVisibility(View.VISIBLE);
            previous_score.setText("Previous Score : "+ ResultActivity.final_Score+"/5");
        }else{
            previous_score.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.start_btn :
                Utilities.First_Ans="";
                Utilities.Second_Ans="";
                Utilities.Third_Ans="";
                Utilities.Fourth_Ans="";
                Utilities.Fifth_Ans="";
                ResultActivity.final_Score=0;
                Utilities.Result_btn_click = false;

                Intent start = new Intent(HomeActivity.this, First_QActivity.class);
                startActivity(start);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Utilities.Result_btn_click){
            previous_score.setVisibility(View.VISIBLE);
            previous_score.setText("Previous Score : "+ ResultActivity.final_Score+"/5");
        }else{
            previous_score.setVisibility(View.GONE);
        }
    }
}
