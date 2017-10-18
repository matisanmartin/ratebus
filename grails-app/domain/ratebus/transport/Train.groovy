package ratebus.transport

class Train extends Transport {

    List<Stop> stops

    static constraints = {
        importFrom Transport
    }

}
