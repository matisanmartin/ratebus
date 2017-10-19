package ratebus.transport

import grails.testing.gorm.DomainUnitTest
import ratebus.transport.BranchLine
import spock.lang.Specification

class BranchLineSpec extends Specification implements DomainUnitTest<BranchLine> {

    BranchLine branchLine

    def setup() {
        branchLine = new BranchLine()
    }

    def cleanup() {
    }

    void "create branchLine with null description"() {
        when:
        branchLine.description = null

        then:
        branchLine.validate(['description'])
    }

    void "create branchLIne with empty description"() {
        when:
        branchLine.description = ""

        then:
        branchLine.validate(['description'])
    }

    void "create branchLine with null shortDescription"() {
        when:
        branchLine.shortDescription = null

        then:
        !branchLine.validate(['shortDescription'])
    }

    void "create branchLine with empty shortDescription"() {
        when:
        branchLine.shortDescription = ""

        then:
        !branchLine.validate(['shortDescription'])
    }

    void "create branchLine with a shortDescription and a description"() {
        when:
        branchLine.shortDescription = "A"
        branchLine.description = "Ramal A"

        then:
        branchLine.shortDescription == "A"
        branchLine.description == "Ramal A"
    }
}
