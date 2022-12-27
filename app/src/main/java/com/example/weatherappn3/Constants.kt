package com.example.weatherappn3

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object  Constants{
    const val APP_ID:String= "f2cf1ffcfa3958e4bba6708000d23bae"
    const val BASE_URL:String="http://api.openweathermap.org/data/"
    const val METRIC_UNIT:String="metric"
    const val PREFERENCE_NAME = "WeatherApp Preference"
    const val WEATHER_RESPONSE_DATA = "weather_response_data"
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManagar = context.
        getSystemService(Context.CONNECTIVITY_SERVICE) as
                ConnectivityManager
if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
val network = connectivityManagar.activeNetwork?: return false
    val activeNetwork = connectivityManagar.getNetworkCapabilities(network)?:return false
    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)->true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)->true
        else->false
    }


}else {
    val networkInfo = connectivityManagar.activeNetworkInfo
    return networkInfo !=null && networkInfo.isConnectedOrConnecting
}


     }

}