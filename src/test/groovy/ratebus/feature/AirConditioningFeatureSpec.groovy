package ratebus.feature

import grails.testing.gorm.DomainUnitTest
import ratebus.feature.AirConditioningFeature
import spock.lang.Specification

class AirConditioningFeatureSpec extends Specification implements DomainUnitTest<AirConditioningFeature> {

    AirConditioningFeature feature
    def setup() {
        feature = new AirConditioningFeature()
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
