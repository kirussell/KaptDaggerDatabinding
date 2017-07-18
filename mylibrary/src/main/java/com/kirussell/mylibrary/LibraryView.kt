package com.kirussell.mylibrary

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.kirussell.mylibrary.databinding.LibViewBinding
import dagger.Subcomponent
import javax.inject.Inject

class LibraryView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
)  : View(context, attrs, defStyleAttr) {

    @Inject lateinit var activity: String
    lateinit var binding: LibViewBinding

    init {
        (context as Holder).get().inject(this)
        binding = LibViewBinding.bind(this)
    }
}

/**
 * To get LibraryComponent from :app module
 */
interface Holder {
    fun get(): LibraryComponent
}

@Subcomponent
interface LibraryComponent {
    fun inject(libView: LibraryView)
}