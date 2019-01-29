package com.power.mortex.mvvm.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.power.mortex.mvvm.BR;
import com.power.mortex.mvvm.R;
import com.power.mortex.mvvm.databinding.ActivitySplashBinding;
import com.power.mortex.mvvm.ui.base.BaseActivity;
import com.power.mortex.mvvm.ui.login.LoginActivity;
import com.power.mortex.mvvm.ui.main.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel splashViewModel;

    private ActivitySplashBinding activitySplashBinding;

    private Boolean paused = false;
    private Handler handler;
    private Runnable runnable;
    private Animation animSlide;

    public static Intent newIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return splashViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashBinding = getViewDataBinding();

        splashViewModel.setNavigator(this);

        animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.splash_anim);

        runnable = () -> {
            if (!paused) {
                splashViewModel.secondTask(getIntent());
            }
        };

        handler = new Handler();

    }

    @Override
    protected void onResume() {
        super.onResume();
        paused = false;
        handler.postDelayed(runnable, 0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        paused = true;
        handler.removeCallbacks(runnable);
    }

    @Override
    public void openMain() {
        Intent intent = MainActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openLogin() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openIntro() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent, animBundle());
        finish();
    }

    @Override
    public void handleIntent(Intent data) {

    }
}
