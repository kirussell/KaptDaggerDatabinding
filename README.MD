[![Build Status](https://travis-ci.org/kirussell/KaptDaggerDatabinding.svg?branch=master)](https://travis-ci.org/kirussell/KaptDaggerDatabinding)

:app
    :mylibrary
        :baseLibrary

while compiling :app module, generated classes for databindings are not visible for dagger

Using both dataBinding object as property and property injected by Dagger is not possible.
Dagger can not resolve generated class and fails

```
./gradlew clean assembleDebug
...
> Task :app:kaptGenerateStubsDebugKotlin
Using kotlin incremental compilation

 error: cannot access LibViewBinding
   class file for com.kirussell.mylibrary.databinding.LibViewBinding not found
   Consult the following stack trace for details.
   com.sun.tools.javac.code.Symbol$CompletionFailure: class file for com.kirussell.mylibrary.databinding.LibViewBinding not found
 java.lang.IllegalStateException: failed to analyze: org.jetbrains.kotlin.kapt3.diagnostic.KaptError: Error while annotation processing
```

MainActivity.kt holds :app component
LibraryView holds :mylibrary components and dataBinding class