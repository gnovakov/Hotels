package com.gnova.hotels.di

import android.content.Context
import com.gnova.hotels.MainActivity
import com.gnova.hotels.di.modules.ApiModule
import com.gnova.hotels.di.modules.AppModule
import com.gnova.hotels.ui.details.DetailFragment
import com.gnova.hotels.ui.hotels.HotelsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: HotelsFragment)
    fun inject(fragment: DetailFragment)


}