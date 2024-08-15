package edu.uchicago.gerber.favs.data.repository

data class Favorites(
    var sessionEmail: String,
    var name: String,
    var alias: String,
    var imageUrl: String,
    var isClosed: Boolean = false,
    var url: String,
    var reviewCount: Int = 0,
    var categories: List<String>,
    var rating: Double = 0.0,
    var coordinates: Coordinates,
    var transactions: List<String>,
    var price: String,
    var location: Location,
    var phone: String,
    var displayPhone: String,
    var distance: Double = 0.0,
    var businessHours: List<String>,
    var attributes: Map<String, String>
)

data class Coordinates(
    var latitude: Double,
    var longitude: Double
)

data class Location(
    var address: String
)