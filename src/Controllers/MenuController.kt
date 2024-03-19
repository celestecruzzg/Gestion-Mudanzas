package Controllers

import Utils.Printer

class MenuController {

    private val printer = Printer()
    private val movingRequestController = MovingRequestController()
    private val clientController = ClientController(printer)
    private val workerController = WorkerController(printer)

    fun showMenu() {
        printer.apply {
            printMsg("\n¡Hola, buen día! Bienvenid@ al menú de 'Gestión de mudanzas' " +
                    "\nPor favor, ingrese una de las opciones mostradas")
            printMsg("\n1 - Registrar un trabajador")
            printMsg("2 - Registrar un cliente")
            printMsg("3 - Crear una solicitud de mudanza")
            printMsg("4 - Mostrar los trabajadores registrados")
            printMsg("5 - Mostrar los clientes registrados")
            printMsg("6 - Mostrar las solicitudes de mudanza registradas" +
                    "\n")

            val opcionSeleccionada = readln().toIntOrNull()
            if (opcionSeleccionada != null) {
                validarOpciones(opcionSeleccionada)
            } else {
                printMsg("Opción inválida. Por favor, seleccione una opción válida.")
                showMenu()
            }
        }
    }

    private fun validarOpciones(opcionSeleccionada: Int) {
        when (opcionSeleccionada) {
            1 -> {
                workerController.registerModel()
                showMenu()
            }
            2 -> {
                clientController.registerModel()
                showMenu()
            }
            3 -> {
                selectWorkerAndClient()
                showMenu()
            }
            4 -> {
                workerController.showAllModels()
                showMenu()
            }
            5 -> {
                clientController.showAllModels()
                showMenu()
            }
            6 -> {
                movingRequestController.showAllModels()
                showMenu()
            }
            else -> {
                printer.printMsg("Opción inválida. Por favor, ingrese un número válido.")
                showMenu()
            }
        }
    }

    private fun selectWorkerAndClient() {

        if (clientController.theresNoRegisteredClients()) {
            printer.printMsg("No se encuentran clientes registrados")
            showMenu()
            return
        }

        if (workerController.theresNoRegisteredWorkers()) {
            printer.printMsg("No se encuentran habitaciones registradas")
            showMenu()
            return
        }

        printer.printMsg("Seleccione un cliente")
        clientController.showAllModels()

        val indexClientSelected = readln().toInt()
        val client = clientController.getClientAtIndex(indexClientSelected - 1)

        printer.printMsg("Seleccione un trabajador")
        workerController.showAllModels()
        val indexWorkerSelect = readln().toInt()
        val worker = workerController.getWorkerAtIndex(indexWorkerSelect - 1)

    }
}

