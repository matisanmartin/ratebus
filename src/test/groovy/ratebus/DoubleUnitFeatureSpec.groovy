package ratebus

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DoubleUnitFeatureSpec extends Specification implements DomainUnitTest<DoubleUnitFeature> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}