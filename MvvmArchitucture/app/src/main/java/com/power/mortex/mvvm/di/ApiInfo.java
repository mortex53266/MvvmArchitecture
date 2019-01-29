package com.power.mortex.mvvm.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Morteza Rahimi on 07/07/17.
 */

@Qualifier
@Retention(RUNTIME)
public @interface ApiInfo {

}
