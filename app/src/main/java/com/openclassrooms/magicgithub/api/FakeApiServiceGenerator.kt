package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User
import java.util.*

object FakeApiServiceGenerator {

    @JvmField
    var FAKE_USERS = mutableListOf(
        User("001", "Jake", "https://robohash.org/1.png"),
        User("002", "Paul", "https://robohash.org/2.png"),
        User("003", "Phil", "https://robohash.org/3.png"),
        User("004", "Guillaume", "https://robohash.org/4.png"),
        User("005", "Francis", "https://robohash.org/5.png"),
        User("006", "George", "https://robohash.org/6.png"),
        User("007", "Louis", "https://robohash.org/7.png"),
        User("008", "Mateo", "https://robohash.org/8.png"),
        User("009", "April", "https://robohash.org/9.png"),
        User("010", "Louise", "https://robohash.org/10.png"),
        User("011", "Elodie", "https://robohash.org/11.png"),
        User("012", "Helene", "https://robohash.org/12.png"),
        User("013", "Fanny", "https://robohash.org/13.png"),
        User("014", "Laura", "https://robohash.org/14.png"),
        User("015", "Gertrude", "https://robohash.org/15.png"),
        User("016", "Chloé", "https://robohash.org/16.png"),
        User("017", "April", "https://robohash.org/17.png"),
        User("018", "Marie", "https://robohash.org/18.png"),
        User("019", "Henri", "https://robohash.org/19.png"),
        User("020", "Rémi", "https://robohash.org/20.png")
    )

    @JvmField
    var FAKE_USERS_RANDOM = Arrays.asList(
        User("021", "Lea", "https://robohash.org/21.png"),
        User("022", "Geoffrey", "https://robohash.org/22.png"),
        User("023", "Simon", "https://robohash.org/23.png"),
        User("024", "André", "https://robohash.org/24.png"),
        User("025", "Leopold", "https://robohash.org/25.png")
    )
}