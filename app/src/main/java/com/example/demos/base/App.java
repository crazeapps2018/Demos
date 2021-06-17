package com.example.demos.base;

import android.app.Application;

import com.example.demos.R;
import com.stripe.android.PaymentConfiguration;
import com.stripe.jetbrains.annotations.NotNull;
import com.stripe.stripeterminal.TerminalLifecycleObserver;

public class App extends Application {

    @NotNull
    private TerminalLifecycleObserver observer;

    @Override
    public void onCreate() {
        super.onCreate();
        // Register the observer for all lifecycle hooks
        observer = TerminalLifecycleObserver.getInstance();
        registerActivityLifecycleCallbacks(observer);
        PaymentConfiguration.init(getApplicationContext(),getResources().getString(R.string.stripe_publishable_key));

    }

    // Don't forget to let the observer know if your application is running low on memory
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        observer.onTrimMemory(level, this);
    }


}
