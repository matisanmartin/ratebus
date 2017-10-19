package ratebus.feature

import grails.testing.gorm.DomainUnitTest
import ratebus.feature.Feature
import spock.lang.Specification

class FeatureSpec extends Specification implements DomainUnitTest<Feature> {

    def setup() {
    }

    def cleanup() {
    }

    void "test create wifi feature"() {
        when:
        Feature feature = new Feature(type: Feature.FeatureType.WIFI, present: Boolean.TRUE)

        then:
        feature.type == Feature.FeatureType.WIFI
        feature.isPresent()
    }

    void "test create heating feature"() {
        when:
        Feature feature = new Feature(type: Feature.FeatureType.HEATING, present: Boolean.FALSE)

        then:
        feature.type == Feature.FeatureType.HEATING
        !feature.isPresent()
    }

    void "test create air conditioning feature"() {
        when:
        Feature feature = new Feature(type: Feature.FeatureType.AIR_CONDITIONING, present: Boolean.TRUE)

        then:
        feature.type == Feature.FeatureType.AIR_CONDITIONING
        feature.isPresent()
    }

    void "test create double unit feature"() {
        when:
        Feature feature = new Feature(type: Feature.FeatureType.DOUBLE_UNIT, present: Boolean.TRUE)

        then:
        feature.type == Feature.FeatureType.DOUBLE_UNIT
        feature.isPresent()
    }

    void "test create seat belt feature"() {
        when:
        Feature feature = new Feature(type: Feature.FeatureType.SEAT_BELT, present: Boolean.TRUE)

        then:
        feature.type == Feature.FeatureType.SEAT_BELT
        feature.isPresent()
    }
}
