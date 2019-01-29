
package com.power.mortex.mvvm.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */

public interface SchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
