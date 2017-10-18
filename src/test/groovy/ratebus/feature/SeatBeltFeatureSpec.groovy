package ratebus.feature

import grails.testing.gorm.DomainUnitTest
import ratebus.feature.SeatBeltFeature
import spock.lang.Specification

class SeatBeltFeatureSpec extends Specification implements DomainUnitTest<SeatBeltFeature> {

    SeatBeltFeature feature

    def setup() {
        feature = new SeatBeltFeature()
    }

    def cleanup() {
    }

    void "test present feature"() {
        when:
        feature.present = Boolean.TRUE

        then:
        feature.isPresent()
    }

    void "test not present feature"() {
        when:
        feature.present = Boolean.FALSE

        then:
        !feature.isPresent()
    }
}
