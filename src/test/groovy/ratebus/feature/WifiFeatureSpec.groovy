package ratebus.feature

import grails.testing.gorm.DomainUnitTest
import ratebus.feature.WifiFeature
import spock.lang.Specification

class WifiFeatureSpec extends Specification implements DomainUnitTest<WifiFeature> {

    WifiFeature feature

    def setup() {
        feature = new WifiFeature()
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
