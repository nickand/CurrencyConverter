# CurrencyConverter
Android Application using http://exchangeratesapi.io/ with https://fixer.io/ API compatibility, since the currency base is from basic plan. Foreign exchange rates and currency conversion JSON API Fixer is a simple and lightweight API for current and historical foreign exchange (forex) rates. 

![currencybanner](https://user-images.githubusercontent.com/4821464/69029427-e1734000-09a2-11ea-88a8-37a1a211379b.png)

## Clean Architecture
<p align="center">
  <img width="460" height="455" src="https://user-images.githubusercontent.com/4821464/66293984-8b908000-e8ad-11e9-9655-24092e6804f8.jpg">
</p>

## Getting Started
This project uses the Gradle system. To build this project, use the gradlew build command or use "Import Project" in Android Studio.

the data comes from Create an app that lists all messages and their details from [exchangeratesapi.io](http://exchangeratesapi.io/)
end points :
* [GET the latest foreign exchange reference rates.](https://api.exchangeratesapi.io/latest) 
* [Rates are quoted against the Euro by default. Quote against a different currency by setting the base parameter in your request.](https://api.exchangeratesapi.io/latest?base=USD) 
* [Request specific exchange rates by setting the symbols parameter.](https://api.exchangeratesapi.io/latest?symbols=USD,GBP)

A collection of samples using the [Architecture Components](https://developer.android.com/arch):

- [Room](https://developer.android.com/topic/libraries/architecture/room) 
- [ViewModels](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Coroutines](https://developer.android.com/topic/libraries/architecture/coroutines)

## Third party libraries
- ![Retrofit](https://square.github.io/retrofit/)
- ![Android Support Design](https://developer.android.com/topic/libraries/support-library/packages)
- ![Koin](https://insert-koin.io/)
- ![Crystal-preloaders](https://github.com/syedowaisali/crystal-preloaders)
- ![Calligraphy](https://github.com/chrisjenx/Calligraphy)
- ![MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)

## TO DO
- Add Documentation
- Add Navigation Component
- Fix update from adapter and use LiveData in some parts
- Remove usecases logic from adapter
- Add tests
