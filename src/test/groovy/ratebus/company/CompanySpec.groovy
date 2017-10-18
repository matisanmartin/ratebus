package ratebus.company

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CompanySpec extends Specification implements DomainUnitTest<Company> {

    Company company

    def setup() {
        company = new Company()
    }

    def cleanup() {
    }

    void "test create company with null name"() {
        when:
        company.name = null

        then:
        !company.validate(['name'])
    }

    void "test create company with empty name"() {
        when:
        company.name = ""

        then:
        !company.validate(['name'])
    }

    void "test create company with null identification"() {
        when:
        company.identification = null

        then:
        !company.validate(['identification'])
    }

    void "test create company with null address"() {
        when:
        company.address = null

        then:
        !company.validate(['address'])
    }


}
