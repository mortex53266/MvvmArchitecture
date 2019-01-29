package com.power.mortex.mvvm.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.power.mortex.mvvm.databinding.ActivityLogin1Binding;
import com.power.mortex.mvvm.ui.base.BaseActivity;
import com.power.mortex.mvvm.ui.verifySms.VerifyPinActivity;

import javax.inject.Inject;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;
import static com.power.mortex.mvvm.BR.viewModel;
import static com.power.mortex.mvvm.R.layout.activity_login1;
import static com.power.mortex.mvvm.R.string.enter_your_full_number;
import static java.lang.String.valueOf;

/**
 * Created by Morteza Rahimi on 08/07/17.
 */

public class LoginActivity extends BaseActivity<ActivityLogin1Binding, LoginViewModel> implements LoginNavigator {

    @Inject
    LoginViewModel mLoginViewModel;

    private ActivityLogin1Binding mActivityLoginBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return viewModel;
    }

    @Override
    public int getLayoutId() {
        return activity_login1;
    }

    @Override
    public LoginViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void login() {
        String phone = mActivityLoginBinding.phoneEt.getText().toString();
        if (mLoginViewModel.isEmailAndPasswordValid(phone)) {
            hideKeyboard();
            mLoginViewModel.login(phone, true);
        } else {
            makeText(this, getString(enter_your_full_number), LENGTH_SHORT).show();
        }
    }

    @Override
    public void openVerifyActivity(Boolean newUser) {
        Intent intent = VerifyPinActivity.newIntent(LoginActivity.this);
        intent.putExtra("IS_NEW_USER", valueOf(newUser));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
    }
}
