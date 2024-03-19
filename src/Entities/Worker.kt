package Entities

class Worker (
    names: String,
    firstLastName: String,
    secondLastName: String,
    phoneNumber: Long,
    val RFC: String,
    val salary: Double,
    val typeWorker: String
) : Person(
    names,
    firstLastName,
    secondLastName,
    phoneNumber
) {
    fun getDataWorker(): String {
        return "Nombre: $names, Apellido Paterno: $firstLastName, Apellido Materno: $secondLastName, Teléfono: $phoneNumber, RFC: $RFC, Salario: $salary, Tipo de trabajador: $typeWorker"
    }

    override fun printPersonType() {
        println("Hola buen día, soy el trabajador ${getFullName()}")
    }
}