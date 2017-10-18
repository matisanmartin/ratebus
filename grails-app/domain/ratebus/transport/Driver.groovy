package ratebus.transport

class Driver {

    String name

    String surName

    String licenseNumber

    static constraints = {
        name nullable: false, blank: false
        surName nullable: false, blank: false
        licenseNumber nullable: false, blank: false
    }
}
