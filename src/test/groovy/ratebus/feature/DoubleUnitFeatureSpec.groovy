package ratebus.feature

import grails.testing.gorm.DomainUnitTest
import ratebus.feature.DoubleUnitFeature
import spock.lang.Specification

class DoubleUnitFeatureSpec extends Specification implements DomainUnitTest<DoubleUnitFeature> {

    DoubleUnitFeature feature

    def setup() {
        feature = new DoubleUnitFeature()
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
