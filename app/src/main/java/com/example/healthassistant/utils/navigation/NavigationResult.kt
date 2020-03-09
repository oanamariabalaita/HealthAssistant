package com.example.healthassistant.utils.navigation

class NavigationResult private constructor(val status: NavigationResultStatus, val data: Any?) {

    companion object {

        fun <T> success(data: T) =
            NavigationResult(
                NavigationResultStatus.SUCCESS,
                data
            )

        fun cancel() = NavigationResult(
            NavigationResultStatus.DISMISSED,
            null
        )
    }

    fun isSuccessful() = status == NavigationResultStatus.SUCCESS

    inline fun <reified K> getResultData(): K {
        check(status == NavigationResultStatus.SUCCESS) { "Can`t get data when the result is not in SUCCESS state" }
        check(data is K) { "Can`t get data which has this type" }
        return data
    }
}