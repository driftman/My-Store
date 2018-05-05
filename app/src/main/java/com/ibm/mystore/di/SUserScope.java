package com.ibm.mystore.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

@Scope
@Retention(RUNTIME)
public @interface SUserScope {}
