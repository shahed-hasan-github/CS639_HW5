package com.shop.hw5

import dagger.Module
import dagger.Provides


@Module
class EngineModule {
    @Provides
    fun provideEngine(): Engine? {
        return Engine()
    }
}