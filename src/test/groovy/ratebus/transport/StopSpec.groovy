package ratebus.transport

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class StopSpec extends Specification implements DomainUnitTest<Stop> {

    Stop stop

    def setup() {
        stop = new Stop()
    }

    def cleanup() {
    }

    void "test create stop with empty name"() {
        when:
        stop.name = ""

        then:
        !stop.validate(['name'])
    }

    void "test create stop with null name"() {
        when:
        stop.name = null

        then:
        !stop.validate(['name'])
    }

    void "test create stop with name"() {
        when:
        stop.name = "Estacion Callao"

        then:
        stop.name == "Estacion Callao"
    }

}
