package com.mao.zi.ui;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mao.zi.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoPlayActivity extends AppCompatActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private ImageView iv_bg;
    private ViewPager viewpager;
    int[] mDrawableId = {R.drawable.bg_welcome1, R.drawable.bg_welcome2, R.drawable.bg_welcome3, R.drawable.bg_welcome4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        initView();
        initData();
    }

    private void initView() {
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.custom_videoplayer_standard);
        iv_bg = (ImageView) findViewById(R.id.iv_bg);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

    }

    private void initData() {
        jcVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4"
                , "哈哈哈");
        viewpager.setAdapter(new WelcomePageAdapter());
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        iv_bg.setVisibility(View.GONE);
//                        Toast.makeText(VideoPlayActivity.this,"ddd",Toast.LENGTH_LONG).show();
                        Animation animation = AnimationUtils.loadAnimation(VideoPlayActivity.this, R.anim.set_animal);
                        viewpager.startAnimation(animation);
                        jcVideoPlayerStandard.setUp("http://starchat.ks3-cn-beijing.ksyun.com/record/live/kstestb8fd7211e5247891e4d4f0562418868a/hls/kstestb8fd7211e5247891e4d4f0562418868a-kstest6645.m3u8"
                                , "哈哈哈");
                        break;
                }
                return false;
            }
        });

    }


    class WelcomePageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mDrawableId.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public Object instantiateItem(ViewGroup parent, int arg1) {
            ImageView v = new ImageView(VideoPlayActivity.this);
            v.setScaleType(ImageView.ScaleType.FIT_XY);
            v.setImageResource(mDrawableId[arg1]);
            parent.addView(v);
            return v;
        }
    }
}
