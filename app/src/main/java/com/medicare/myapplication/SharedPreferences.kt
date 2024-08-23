package com.medicare.myapplication

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("game_stats", Context.MODE_PRIVATE)

    companion object {
        private const val TOTAL_WINS_KEY = "total_wins"
        private const val TOTAL_LOSSES_KEY = "total_losses"
    }

    fun saveTotalWins(totalWins: Int) {
        sharedPreferences.edit().putInt(TOTAL_WINS_KEY, totalWins).apply()
    }

    fun saveTotalLosses(totalLosses: Int) {
        sharedPreferences.edit().putInt(TOTAL_LOSSES_KEY, totalLosses).apply()
    }

    fun getTotalWins(): Int {
        return sharedPreferences.getInt(TOTAL_WINS_KEY, 0)
    }

    fun getTotalLosses(): Int {
        return sharedPreferences.getInt(TOTAL_LOSSES_KEY, 0)
    }
}
