package com.awak.wekare


import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class]
)
interface ActivityComponent {


//    fun inject(videoCallActivity: TwilioVideoCallActivity)
}