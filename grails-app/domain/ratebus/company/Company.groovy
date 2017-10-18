package ratebus.company

import ratebus.address.Address

class Company {

    String name

    Long identification

    Address address

    static constraints = {
        name nullable: false, blank: false, unique: true
        identification nullable: false, unique: true
        address nullable: false
    }
}
