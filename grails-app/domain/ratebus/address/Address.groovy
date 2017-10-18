package ratebus.address

class Address {

    String location

    String street

    Long number

    String country

    String contactNumber

    static constraints = {
        location nullable: false, blank: false
        street nullable: false, blank: false
        number nullable: false
        country nullable: false, blank: false
        contactNumber nullable: false, blank: false
    }
}
