package com.shop.hw5

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    var car: Car? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (application as MyApplication).getCarComponent()?.inject(this)


        val startButton = findViewById<Button>(R.id.startButton)


        startButton.setOnClickListener {
            car?.start()
        }
    }
}


class Car {
    private var engine: Engine? = null

    @SuppressLint("NotConstructor")
    @Inject
    fun Car(engine: Engine?) {
        this.engine = engine
    }

    fun start() {

        println("Car has started!")
    }
}

public class Engine {

}

class MyApplication : Application() {
    private var carComponent: CarComponent? = null
    override fun onCreate() {
        super.onCreate()
        carComponent = DaggerCarComponent.builder()
            .engineModule(EngineModule())
            .build()
    }

    fun getCarComponent(): CarComponent? {
        return carComponent
    }
}



