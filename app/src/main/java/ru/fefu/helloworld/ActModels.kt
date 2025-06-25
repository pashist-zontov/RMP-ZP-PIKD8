package ru.fefu.helloworld


sealed class ActItem {
    data class Header (val date: String) : ActItem()
    data class Act(
        val id: Int,
        val type: String,
        val distance: String,
        val duration: String,
        val lastTime: String
    ) : ActItem()
}

sealed class ActItemU {
    data class Header(val date: String) : ActItemU()
    data class Act(
        val id: Int,
        val type: String,
        val distance: String,
        val duration: String,
        val timeAgo: String,
        val userName: String
    ) : ActItemU()
}

object UserActivitiesData {
    val activities = listOf(
        ActItemU.Act(
            1,
            "Бег",
            "5.2 км",
            "30 минут",
            "10 часов назад",
            "@van_darkholme"
        ),
        ActItemU.Act(
            2,
            "Велоспорт",
            "15.7 км",
            "45 минут",
            "5 часов назад",
            "@cirno"
        ),
        ActItemU.Act(
            3,
            "Плавание",
            "1.2 км",
            "25 минут",
            "1 час назад",
            "@armstrong"
        )
    )
}