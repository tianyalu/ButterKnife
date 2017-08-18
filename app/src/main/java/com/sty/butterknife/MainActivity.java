package com.sty.butterknife;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private Handler handler;

    private TextView tv3;
    private Button btn3;

    //注解控件
    @BindString(R.string.app_name)
    String butterKnifeStr;
    @BindView(R.id.tv1)
    TextView butterKnifeTv1;
    @BindView(R.id.tv2)
    TextView butterKnifeTv2;

    @BindDrawable(R.drawable.flower)
    Drawable butterKnifeDrawable;
    @BindView(R.id.iv1)
    ImageView butterKnifeIv;

    @BindView(R.id.btn1)
    Button butterKnifeBtn1;
//    @BindView(R.id.btn2)
//    Button butterKnifeBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        setListeners();
    }

    protected void initViews(){
        butterKnifeTv1.setText(butterKnifeStr);
        butterKnifeIv.setImageDrawable(butterKnifeDrawable);

        tv3 = (TextView) findViewById(R.id.tv3);
        btn3 = (Button) findViewById(R.id.btn3);
    }

    protected void setListeners(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch(msg.what){
                    case 1:
                        butterKnifeTv1.setText("按钮1被点击");
                        break;
                    case 2:
                        butterKnifeTv2.setText("按钮2被点击");
                        break;
                    case 3:
                        tv3.setText("按钮3被点击");
                        break;
                    default:
                        break;
                }
            }
        };

        butterKnifeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(3);
                    }
                }).start();
            }
        });

    }

    //注解监听器
    @OnClick(R.id.btn2)
    public void onButterKnifeBtnClick(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(2);
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
