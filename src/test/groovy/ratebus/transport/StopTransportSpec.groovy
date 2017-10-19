package ratebus.transport

import grails.testing.gorm.DomainUnitTest
import ratebus.address.Address
import ratebus.company.Company
import ratebus.transport.Stop
import ratebus.transport.StopTransport
import spock.lang.Specification

class StopTransportSpec extends Specification implements DomainUnitTest<StopTransport> {

    StopTransport stopTransport
    Stop pueyrredon
    Stop callao

    def setup() {
        Address address = new Address(location: 'Buenos Aires', street: 'Calle Falsa', number: 123, country: 'Argentina', contactNumber: '1234-5678')
        Company company = new Company(name: 'Metrovias', identification: 123, address: address, )
        stopTransport = new StopTransport(name: 'Linea D', company: company)
        pueyrredon = new Stop(name: 'Pueyrredon')
        callao = new Stop(name: 'Callao')
    }

    def cleanup() {
    }

    void "test create stop transport and add stop when stops are null"() {
        when:
        stopTransport.stops = null

        then:
        stopTransport.validate(['stops'])
    }

    void "test create stop transport and add stop when stops are empty"() {
        when:
        stopTransport.stops = []
        stopTransport.addStop(pueyrredon)

        then:
        stopTransport.stops.size() == 1
        stopTransport.stops.any { it.name = pueyrredon.name }
    }

    void "test create stop transport and add existing stop"() {
        setup:
        stopTransport.stops = []
        stopTransport.addStop(pueyrredon)

        when:
        stopTransport.addStop(pueyrredon)

        then:
        Exception e = thrown()
        e.message == "No se puede agregar una parada ya existente en la lista"
    }

    void "test create stop transport and remove stop when stops are null"() {
        setup:
        stopTransport.stops = null

        when:
        stopTransport.removeStop(pueyrredon)

        then:
        Exception e = thrown()
        e.message == "No se puede elimniar la parada ya que no existe ninguna"
    }

    void "test create stop transport and remove stop when stops are empty"() {
        setup:
        stopTransport.stops = []

        when:
        stopTransport.removeStop(pueyrredon)

        then:
        Exception e = thrown()
        e.message == "No se puede elimniar la parada ya que no existe ninguna"
    }

    void "test create stop transport and remove stop when the stops doesnt exist"() {
        setup:
        stopTransport.stops = [pueyrredon]

        when:
        stopTransport.removeStop(callao)

        then:
        stopTransport.stops.size() == 1
        stopTransport.stops.any { it.name == pueyrredon.name}

    }

    void "test create stop transport and remove stop when the stop exists"() {
        setup:
        stopTransport.stops = [pueyrredon, callao]

        when:
        stopTransport.removeStop(pueyrredon)

        then:
        stopTransport.stops.size() == 1
        stopTransport.stops.any { it.name == callao.name}
        !stopTransport.stops.any { it.name == pueyrredon.name}
    }
}
