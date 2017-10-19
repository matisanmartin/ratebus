package ratebus.transport

import grails.testing.gorm.DomainUnitTest
import ratebus.transport.Bus
import spock.lang.Specification

class BusSpec extends Specification implements DomainUnitTest<Bus> {

    Bus bus
    def setup() {
        bus = new Bus()
    }

    def cleanup() {
    }

    void "test create Bus with no stops"() {

    }
}
