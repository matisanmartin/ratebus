package ratebus.feature

import grails.testing.gorm.DomainUnitTest
import ratebus.feature.HeatingFeature
import spock.lang.Specification

class HeatingFeatureSpec extends Specification implements DomainUnitTest<HeatingFeature> {

    HeatingFeature feature

    def setup() {
        feature = new HeatingFeature()
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
