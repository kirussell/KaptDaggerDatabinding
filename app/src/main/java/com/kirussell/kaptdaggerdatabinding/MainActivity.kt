package com.kirussell.kaptdaggerdatabinding

import android.app.Activity
import android.os.Bundle
import com.kirussell.mylibrary.Holder
import com.kirussell.mylibrary.LibraryComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class MainActivity : Activity(), Holder {

    @Inject lateinit var value: String

    private lateinit var component: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lib_view)
        component = DaggerMainComponent.builder().build()
    }

    override fun get(): LibraryComponent = component.plus()
}

@Component(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun plus(): LibraryComponent
}

@Module
abstract class MainModule {
    @Provides fun provide() = "123"
}