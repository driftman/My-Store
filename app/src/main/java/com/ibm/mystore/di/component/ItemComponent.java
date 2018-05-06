package com.ibm.mystore.di.component;

import com.ibm.mystore.di.ItemsScope;
import com.ibm.mystore.di.module.ItemModule;
import com.ibm.mystore.ui.item.ItemsActivity;
import com.ibm.mystore.ui.item.fragment.ItemsFragment;

import dagger.Subcomponent;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

@ItemsScope
@Subcomponent(modules = {ItemModule.class})
public interface ItemComponent {

    void inject(ItemsFragment fragment);

}
