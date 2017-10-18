package ratebus.transport

class Subway extends Transport {

    SubwayLine line

    static constraints = {
        importFrom Transport
        line nullable: false, blank: false
    }

    enum SubwayLine {
        A, B, C, D, E, H
    }
}
