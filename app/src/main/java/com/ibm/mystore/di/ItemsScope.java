package com.ibm.mystore.di;


import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


import javax.inject.Scope;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

@Scope
@Retention(RUNTIME)
public @interface ItemsScope {}
