package com.bsl.yulin.bullseye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView show;
    private TextView num1;
    private TextView num2;
    private Button play;
    private Button replay;
    private Button help;
    private SeekBar bar;

    int randnum;
    int finalnum;
    int y = 0;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewInit();//控件初始化
        randNumber();//产生一个随机数，放入TextView-show中

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sum();//判断拖动进度条的位置与给出的数值的差距
                randNumber();//产生一个随机数，放入TextView-show中
            }
        });
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("分数：0");
                num2.setText("局数：1");
                bar.setProgress(0);
                y = 0;
                i = 0;
                randNumber();//产生一个随机数，放入TextView-show中
            }
        });
    }

    private void Sum() {
        int progress = bar.getProgress();
        finalnum = Math.abs(progress - randnum);//abs求两个数的绝对值
        if (finalnum <= 5) {
            y = y + 100;
            num1.setText("分数："+y);
        } else if (finalnum <= 10) {
            y = y + 90;
            num1.setText("分数："+y);
        } else if (finalnum <= 15) {
            y = y + 80;
            num1.setText("分数："+y);
        } else if (finalnum <= 20) {
            y = y + 70;
            num1.setText("分数：" + y);
        } else {
            y = y + 60;
            num1.setText("分数："+y);
        }
        i = i + 1;
        num2.setText("局数："+i);
        bar.setProgress(0);
    }

    private void randNumber() {//产生一个随机数，放入TextView-show中
        Random rand = new Random();
        randnum = rand.nextInt(99) + 1;
        show.setText("把进度条拖到："+randnum);
    }

    private void ViewInit() {
        show = (TextView) findViewById(R.id.show_tv);
        num1 = (TextView) findViewById(R.id.textView);
        num2 = (TextView) findViewById(R.id.textView2);

        play = (Button) findViewById(R.id.play);
        replay = (Button) findViewById(R.id.replay);
        help = (Button) findViewById(R.id.help);

        bar = (SeekBar) findViewById(R.id.sb);


    }
}
