package ratebus.feature

import grails.testing.gorm.DomainUnitTest
import ratebus.feature.Feature
import spock.lang.Specification

class FeatureSpec extends Specification implements DomainUnitTest<Feature> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
