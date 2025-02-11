package com.osman.firebaseanalyticscrashlytics

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.analytics.FirebaseAnalytics
import com.osman.firebaseanalyticscrashlytics.databinding.ActivityMainBinding
import com.osman.firebaseanalyticscrashlytics.ui.theme.FirebaseAnalyticsCrashlyticsTheme

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Burada inflate et
        setContentView(binding.root)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)


    }


    fun favorilereEklendi(view: View) {
        val veriBundle = Bundle()
        veriBundle.putString("kullanici", "osman")
        firebaseAnalytics.logEvent("favarilereEkleTiklandi", veriBundle)// event ekledik

        throw RuntimeException("Test crash")   //crashlytics   raporlara eklenir
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseAnalyticsCrashlyticsTheme {
        Greeting("Android")
    }
}