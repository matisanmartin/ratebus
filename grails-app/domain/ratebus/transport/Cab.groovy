package ratebus.transport

class Cab extends Transport {

    String licensePlate

    Driver driver

    static constraints = {
        importFrom Transport
    }
}
