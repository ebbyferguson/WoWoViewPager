package com.nightonke.wowoviewpagerexample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.nightonke.wowoviewpager.Eases.EaseType;
import com.nightonke.wowoviewpager.ViewAnimation;
import com.nightonke.wowoviewpager.WoWoTranslationAnimation;
import com.nightonke.wowoviewpager.WoWoUtil;
import com.nightonke.wowoviewpager.WoWoViewPager;
import com.nightonke.wowoviewpager.WoWoViewPagerAdapter;

public class WoWoTranslationAnimationActivity extends AppCompatActivity {

    private WoWoViewPager wowo;
    private WoWoViewPagerAdapter adapter;
    
    private EaseType easeType = EaseType.EaseInCubic;
    private boolean useSameEaseTypeBack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_wowo_translation_animation);

        init();

        int screenW = WoWoUtil.getScreenWidth(this);
        int screenH = WoWoUtil.getScreenHeight(this);

        wowo = (WoWoViewPager)findViewById(R.id.wowo_viewpager);
        adapter = new WoWoViewPagerAdapter(getSupportFragmentManager());
        adapter.setFragmentsNumber(5);
        adapter.setColorRes(R.color.white);
        wowo.setAdapter(adapter);
        setPageTV(wowo);

        ViewAnimation animation = new ViewAnimation(findViewById(R.id.android));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                0, 0f, 1f,
                -screenW / 2 + WoWoUtil.dp2px(40, this),
                -screenH / 2 + WoWoUtil.dp2px(40, this),
                easeType,
                useSameEaseTypeBack));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                1, 0f, 1f,
                screenW - WoWoUtil.dp2px(80, this),
                screenH - WoWoUtil.dp2px(80, this),
                easeType,
                useSameEaseTypeBack));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                2, 0f, 0.5f,
                0,
                -screenH / 2 + WoWoUtil.dp2px(40, this),
                easeType,
                useSameEaseTypeBack));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                2, 0.5f, 1f,
                -screenW + WoWoUtil.dp2px(80, this),
                0,
                easeType,
                useSameEaseTypeBack));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                3, 0f, 0.5f,
                screenW / 2 - WoWoUtil.dp2px(40, this),
                -screenH / 2 + WoWoUtil.dp2px(40, this),
                easeType,
                useSameEaseTypeBack));
        animation.addPageAnimaition(new WoWoTranslationAnimation(
                3, 0.5f, 1f,
                0,
                screenH / 2 - WoWoUtil.dp2px(40, this),
                easeType,
                useSameEaseTypeBack));
        wowo.addAnimation(animation);
    }

    private void setPageTV(WoWoViewPager wowo) {
        wowo.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((TextView)findViewById(R.id.page)).setText((position + 1) + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void init() {
        useSameEaseTypeBack = getIntent().getBooleanExtra("useSameEaseTypeBack", true);
        int easeTypeNumber = getIntent().getIntExtra("easeType", -1);
        switch (easeTypeNumber) {
            case 0: easeType = EaseType.EaseInSine; break;
            case 1: easeType = EaseType.EaseOutSine; break;
            case 2: easeType = EaseType.EaseInOutSine; break;
            case 3: easeType = EaseType.EaseInQuad; break;
            case 4: easeType = EaseType.EaseOutQuad; break;
            case 5: easeType = EaseType.EaseInOutQuad; break;
            case 6: easeType = EaseType.EaseInCubic; break;
            case 7: easeType = EaseType.EaseOutCubic; break;
            case 8: easeType = EaseType.EaseInOutCubic; break;
            case 9: easeType = EaseType.EaseInQuart; break;
            case 10: easeType = EaseType.EaseOutQuart; break;
            case 11: easeType = EaseType.EaseInOutQuart; break;
            case 12: easeType = EaseType.EaseInQuint; break;
            case 13: easeType = EaseType.EaseOutQuint; break;
            case 14: easeType = EaseType.EaseInOutQuint; break;
            case 15: easeType = EaseType.EaseInExpo; break;
            case 16: easeType = EaseType.EaseOutExpo; break;
            case 17: easeType = EaseType.EaseInOutExpo; break;
            case 18: easeType = EaseType.EaseInCirc; break;
            case 19: easeType = EaseType.EaseOutCirc; break;
            case 20: easeType = EaseType.EaseInOutCirc; break;
            case 21: easeType = EaseType.EaseInBack; break;
            case 22: easeType = EaseType.EaseOutBack; break;
            case 23: easeType = EaseType.EaseInOutBack; break;
            case 24: easeType = EaseType.EaseInElastic; break;
            case 25: easeType = EaseType.EaseOutElastic; break;
            case 26: easeType = EaseType.EaseInOutElastic; break;
            case 27: easeType = EaseType.EaseInBounce; break;
            case 28: easeType = EaseType.EaseOutBounce; break;
            case 29: easeType = EaseType.EaseInOutBounce; break;
            case 30: easeType = EaseType.Linear; break;
        }
    }
}
