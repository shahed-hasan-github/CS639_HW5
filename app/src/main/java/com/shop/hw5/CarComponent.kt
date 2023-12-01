package com.shop.hw5

import dagger.Component

@Component(modules = arrayOf(EngineModule::class))
interface CarComponent {
    fun inject(car: MainActivity)
}