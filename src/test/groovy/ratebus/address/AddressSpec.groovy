package ratebus.address

import grails.testing.gorm.DomainUnitTest
import ratebus.address.Address
import spock.lang.Specification

class AddressSpec extends Specification implements DomainUnitTest<Address> {

    Address address
    def setup() {
        address = new Address()
    }

    def cleanup() {
    }

    void "test create Address with empty location"() {
        when:
        address.location = ""

        then:
        !address.validate(['location'])
    }

    void "test create Address with null location"() {
        when:
        address.location = null

        then:
        !address.validate(['location'])
    }

    void "test create Address with null street"() {
        when:
        address.street = null

        then:
        !address.validate(['street'])
    }

    void "test create Address with empty street"() {
        when:
        address.street = ""

        then:
        !address.validate(['street'])
    }

    void "test create Address with null number"() {
        when:
        address.number = null

        then:
        !address.validate(['number'])
    }

    void "test create Address with null country"() {
        when:
        address.country = null

        then:
        !address.validate(['country'])
    }

    void "test create Address with empty Country"() {
        when:
        address.country = ""

        then:
        !address.validate(['country'])
    }

    void "test create Address with null contactNumber"() {
        when:
        address.contactNumber = null

        then:
        !address.validate(['contactNumber'])
    }

    void "test create Address with empty contactNumber"() {
        when:
        address.contactNumber = ""

        then:
        !address.validate(['contactNumber'])
    }
}
