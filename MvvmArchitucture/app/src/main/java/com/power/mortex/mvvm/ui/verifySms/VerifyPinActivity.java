package com.power.mortex.mvvm.ui.verifySms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.power.mortex.mvvm.BR;
import com.power.mortex.mvvm.R;
import com.power.mortex.mvvm.databinding.ActivityVerifyPinBinding;
import com.power.mortex.mvvm.ui.base.BaseActivity;
import com.power.mortex.mvvm.ui.main.MainActivity;

import javax.inject.Inject;

public class VerifyPinActivity extends BaseActivity<ActivityVerifyPinBinding, VerifyPinViewModel> implements VerifyPinNavigator {

    @Inject
    VerifyPinViewModel verifyPinViewModel;

    private ActivityVerifyPinBinding activityVerifyPinBinding;
    private String vendorId;

    public static Intent newIntent(Context context) {

        return new Intent(context, VerifyPinActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_verify_pin;
    }

    @Override
    public VerifyPinViewModel getViewModel() {
        return verifyPinViewModel;
    }

    @Override
    public void handelError(Throwable throwable) {

    }

    @Override
    public void verifyPin() {
        String pin = activityVerifyPinBinding.pinEt.getText().toString();
        if (verifyPinViewModel.isPinValid(pin)) {
            hideKeyboard();
            verifyPinViewModel.verifyPin(verifyPinViewModel.getDataManager().getUserPhone(), pin, vendorId, true);
        } else {
            Toast.makeText(this, "pin is not valid", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void decideMainGetNiceName() {
        if (Boolean.valueOf(getIntent().getStringExtra("IS_NEW_USER"))) {
            ///getNicname
            Toast.makeText(this, "nicname", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = MainActivity.newIntent(VerifyPinActivity.this);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityVerifyPinBinding = getViewDataBinding();
        verifyPinViewModel.setNavigator(this);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            return;
                        }

                        vendorId = task.getResult().getToken();
                        FirebaseMessaging.getInstance().subscribeToTopic("all_device");

                    }
                });
    }

}
