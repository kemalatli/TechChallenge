![Tivi](https://github.com/kemalatli/TechChallenge/blob/master/app/src/main/res/mipmap-xhdpi/ic_launcher.png?raw=true)

# Marketim App

**This application was developed for the 2<sup>nd</sup> stage of Tech Challenge**

Marketim app consists of two features:
* Login feature for authenticating the user.
* Orders feature for viewing orders fetched from the given endpoint.

## Android development

Marketim app is developed in MVVM architecture which is supported by Android Architecture Components. It has 3 layers of abstraction as view, domain and data. View components are managed by DataBinding library. RxJava was used as primary tool for the communication between data and viewmodel layers.

Quick notes about the app:

 * Entirely written in Kotlin
 * RxJava2 and Retrofit for networking and inter-layer communications
 * Koin as Dependency Injection framework
 * Architecture Components and Data Binding for View - ViewModel abstractions


## 3<sup>rd</sup> Party Open Source Libraries

 * [Koin](https://github.com/InsertKoinIO/koin) as dependency injection framework
 * [Retrofit](http://square.github.io/retrofit) for networking purposes
 * [Epoxy](https://github.com/airbnb/epoxy) for recyclerview model building
 * [MvRx](https://github.com/airbnb/mvrx) for fragment state management
 * [RxJava](https://github.com/ReactiveX/RxJava) for threading and interlayer communications


## License

```
The MIT License

Copyright (c) 2010-2019 Google, Inc. http://angularjs.org
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```