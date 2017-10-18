package ratebus.transport

class Bus extends Transport {

    List<Stop> busStops

    static constraints = {
        importFrom Transport
    }
}
