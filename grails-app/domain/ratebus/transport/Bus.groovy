package ratebus.transport

class Bus extends Transport {

    String unitNumber

    static constraints = {
        importFrom Transport
        unitNumber nullable: false, blank: false
    }


}
