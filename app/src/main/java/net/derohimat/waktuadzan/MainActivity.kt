package net.derohimat.waktuadzan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.batoulapps.adhan.CalculationMethod
import com.batoulapps.adhan.Coordinates
import com.batoulapps.adhan.Madhab
import com.batoulapps.adhan.PrayerTimes
import com.batoulapps.adhan.data.DateComponents
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coordinates = Coordinates(-7.123123, 107.123452)
        val currentDateTime = Date()
        val date = DateComponents.from(currentDateTime)
        val params = CalculationMethod.MUSLIM_WORLD_LEAGUE.parameters
        params.madhab = Madhab.SHAFI
        params.adjustments.fajr = -6

        val prayerTimes = PrayerTimes(coordinates, date, params)

        val formatter = SimpleDateFormat("HH:mm")

        val times = "Current : ${prayerTimes.currentPrayer()}\n\n" +
                "Next :  ${prayerTimes.nextPrayer()} ${formatter.format(prayerTimes.timeForPrayer(prayerTimes.nextPrayer()))}\n\n" +
                "Subuh : ${formatter.format(prayerTimes.fajr)}\n\n" +
                "Terbit : ${formatter.format(prayerTimes.sunrise)}\n\n" +
                "Dzuhur : ${formatter.format(prayerTimes.dhuhr)}\n\n" +
                "Ashar : ${formatter.format(prayerTimes.asr)}\n\n" +
                "Maghrib : ${formatter.format(prayerTimes.maghrib)}\n\n" +
                "Isya : ${formatter.format(prayerTimes.isha)}"

        txtNextAdzan.text = times
    }

}