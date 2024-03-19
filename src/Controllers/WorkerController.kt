package Controllers

import Entities.Worker
import Utils.Printer

class WorkerController(val printer: Printer) : AdministratorController {

    private val workerList = mutableListOf<Worker>()

    override fun registerModel() {
        printer.apply {
            printMsg("Ingrese el nombre(s):")
            val workerNames = readln()
            printMsg("Ingrese el apellido paterno:")
            val workerFirstLastName = readln()
            printMsg("Ingrese el apellido materno:")
            val workerSecondLastName = readln()
            printMsg("Ingrese el número celular:")
            val phoneNumber = readln().toLong()
            printMsg("Ingrese el RFC:")
            val RFC = readln()
            printMsg("Ingrese el salario que va a percibir:")
            val salary = readln().toDouble()
            printMsg("Ingrese el tipo de empleado:")
            val typeWorker = readln()

            val worker = Worker(
                workerNames,
                workerFirstLastName,
                workerSecondLastName,
                phoneNumber,
                RFC,
                salary,
                typeWorker
            )

            workerList.add(worker)
            printMsg("¡El trabajador ha sido registrado exitosamente!")
        }
    }

    override fun showAllModels() {
        if (workerList.isEmpty()) {
            printer.printMsg("No se encuentran trabajadores registrados")
        } else {
            var contador = 1
            for (worker in workerList) {
                printer.printMsg("$contador-" + worker.getDataWorker())
                contador++
            }
        }
    }

    fun getWorkerAtIndex(index: Int): Worker? {
        return workerList.getOrNull(index)
    }

    fun theresNoRegisteredWorkers(): Boolean {
        return workerList.isEmpty()
    }
}