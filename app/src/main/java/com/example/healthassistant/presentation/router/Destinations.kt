package com.example.healthassistant.presentation.router

import com.example.healthassistant.presentation.router.Destinations.CardDetailArgs.CardId

object Destinations {

    const val INTRO_ROUTE = "intro"
    const val DASHBOARD_ROUTE = "dashboard"
    const val PROFILE_ROUTE = "profile?userId={userId}"
    const val STATISTICS_ROUTE = "statistics"
    const val CARD_DETAILS_ROUTE = "cardDetail/{$CardId}"
    const val ADD_RECORD_ROUTE = "record"
    const val NOTIFICATIONS_ROUTE = "notifications"
    const val SETTINGS_ROUTE = "settings"

    object CardDetailArgs {
        const val CardId = "cardId"
    }
}
