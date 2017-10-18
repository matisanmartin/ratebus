package ratebus.transport

class Subway extends Transport {

    List<Stop> subwayStops

    static constraints = {
        importFrom Transport
    }
}
