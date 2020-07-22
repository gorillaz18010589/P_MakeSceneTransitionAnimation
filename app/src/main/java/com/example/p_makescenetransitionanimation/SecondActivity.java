package com.example.p_makescenetransitionanimation;
//Window.setEnterTransition(Transition transition):轉場開始特效
//Window.setExitTransition(Transition transition):轉場開始特效
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity {
    private LinearLayout linCon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        linCon = findViewById(R.id.linCon);
//        setScale();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            //下拉
//            getWindow().setEnterTransition(new Slide().setDuration(1000));
//            getWindow().setExitTransition(new Slide().setDuration(001));

            //分解
//            getWindow().setEnterTransition(new Explode().setDuration(2000));
//            getWindow().setExitTransition(new Explode().setDuration(2000));

            //淡入淡出
            getWindow().setEnterTransition(new Fade().setDuration(100));
            getWindow().setExitTransition(new Fade().setDuration(100));


        } else {

        }
    }

    //設定容器縮放特效
    private void setScale() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.scale);
        linCon.setAnimation(animation);
    }
}
