package Controllers

import Entities.Client
import Utils.Printer

class ClientController(val printer: Printer) : AdministratorController {

    private val clientList = mutableListOf<Client>()

    override fun registerModel() {
        printer.apply {
            printMsg("Por favor, ingrese el nombre(s)")
            val clientNames = readln()
            printMsg("Ingrese el apellido paterno")
            val clientFirstLastName = readln()
            printMsg("Ingrese el apellido materno")
            val clientSecondLastName = readln()
            printMsg("Por favor, registre el número celular")
            val phoneNumber = readln().toLong()
            printMsg("Por favor, registre la dirección")
            val address = readln()

            val client = Client(
                clientNames,
                clientFirstLastName,
                clientSecondLastName,
                phoneNumber,
                address
            )

            clientList.add(client)
            printMsg("El cliente ha sido registrado exitosamente.")
        }
    }

    override fun showAllModels() {
        if (clientList.isEmpty()) {
            printer.printMsg("No se encuentran clientes registrados")
        } else {
            var contador = 1
            for (client in clientList) {
                printer.printMsg("$contador-" + client.getDataClient())
                contador++
            }
        }
    }

    fun getClientAtIndex(index: Int): Client? {
        return clientList.getOrNull(index)
    }

    fun theresNoRegisteredClients(): Boolean {
        return clientList.isEmpty()
    }
}