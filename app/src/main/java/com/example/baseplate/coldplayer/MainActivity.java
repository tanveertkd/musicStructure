package com.example.baseplate.coldplayer;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mDotsIndicator;

    private TextView[] mDots;

    private slideAdapter slideAdapter;

    private Button mnextBtn;
    private Button mbackBtn;
    private int cPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.slider);
        mDotsIndicator = (LinearLayout) findViewById(R.id.dotsIndicator);
        mbackBtn = (Button) findViewById(R.id.backBtn);
        mnextBtn = (Button) findViewById(R.id.nextBtn);

        slideAdapter = new slideAdapter(this);
        mViewPager.setAdapter(slideAdapter);

        dotsIndicator(0);

        mViewPager.addOnPageChangeListener(changeListener);

        mnextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(cPage + 1);
            }
        });

        mbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(cPage - 1);
            }
        });
    }

    public void dotsIndicator(int position){
        mDots = new TextView[3];
        mDotsIndicator.removeAllViews();
        for(int i=0; i<mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.dot));

            mDotsIndicator.addView(mDots[i]);
        }
        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.dotIndicator));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            dotsIndicator(position);
            cPage = position;

            if(position == 0){
                mnextBtn.setEnabled(true);
                mbackBtn.setEnabled(false);
                mbackBtn.setVisibility(View.INVISIBLE);

                mnextBtn.setText("Next");
                mbackBtn.setText("");
            } else if (position == mDots.length-1) {
                mnextBtn.setEnabled(true);
                mbackBtn.setEnabled(true);
                mbackBtn.setVisibility(View.VISIBLE);

                mnextBtn.setText("Finish");
                mbackBtn.setText("Back");
                //for intent
                mnextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent home = new Intent(MainActivity.this, navigation.class);
                        startActivity(home);
                        finish();
                    }
                });
            } else {
                mnextBtn.setEnabled(true);
                mbackBtn.setEnabled(true);
                mbackBtn.setVisibility(View.VISIBLE);

                mnextBtn.setText("Next");
                mbackBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
