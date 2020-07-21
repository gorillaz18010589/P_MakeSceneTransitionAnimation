package com.example.p_makescenetransitionanimation;
//1.style = > <item name="android:windowContentTransitions" tools:ignore="NewApi">true</item>代表同意使用特效
//2.在要做效果的元件上用android:transitionName="transition2"綁定雙方
//3.準備ActivityOptions.makeSceneTransitionAnimation方法,製造綁定特效果
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tv1, tv2 ,tv3;
    private Button btnToPage2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/* ActivityOptions ActivityOptions.makeSceneTransitionAnimation(
        1.Activity activity, => 綁定這個activity
        2. Pair<View, String>... sharedElements => 準備好的元件(1.元件id, 2.要連接有綁定的transitio)
)

* */

        init();
        btnToPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                //3.準備ActivityOptions.makeSceneTransitionAnimation方法,製造綁定特效果
                Pair[] pairs = new Pair[4];
                pairs[0]  = new Pair<View,String>(imageView,"transition1");
                pairs[1]  = new Pair<View,String>(tv1,"transitio2");
                pairs[2]  = new Pair<View,String>(tv2,"transitio3");
                pairs[3]  = new Pair<View,String>(tv3,"transitio4");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,activityOptions.toBundle());
                }else{
                    Log.v("hank","小於的版本沒效果");
                }

            }
        });

    }

    private void init() {
        imageView = findViewById(R.id.img);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        btnToPage2 = findViewById(R.id.btnToPage2);
    }
}
