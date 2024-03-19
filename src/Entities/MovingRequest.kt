package Entities

class MovingRequest (
    val client: Client,
    val worker: Worker,
    val totalPrice: Double,
    var isCancelled: Boolean = false,
    val dueDate: String
)