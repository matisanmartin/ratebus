package ratebus.transport

class Stop {

    String name

    static constraints = {
        name nullable: false, blank: false
    }
}
