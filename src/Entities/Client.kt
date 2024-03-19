package Entities

class Client (
    names: String,
    firstLastName: String,
    secondLastName: String,
    phoneNumber: Number,
    val address: String
) : Person(
    names,
    firstLastName,
    secondLastName,
    phoneNumber
) {
    fun getDataClient(): String {
        return "Nombre: $names, Apellido Paterno: $firstLastName, Apellido Materno: $secondLastName, Teléfono: $phoneNumber, Dirección: $address"
    }


    override fun printPersonType() {
        println("Hola buen día, soy el cliente ${getFullName()}")
    }
}