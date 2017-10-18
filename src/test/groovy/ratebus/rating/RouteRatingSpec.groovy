package ratebus.rating

import grails.testing.gorm.DomainUnitTest
import ratebus.rating.RouteRating
import spock.lang.Specification

class RouteRatingSpec extends Specification implements DomainUnitTest<RouteRating> {

    RouteRating rating

    def setup() {
        rating = new RouteRating()
    }

    def cleanup() {
    }

    def "test create route rating with GOOD RatingNumber"() {
        when:
        rating.ratingNumber = Rating.RatingNumber.GOOD
        rating.comment = "good"

        then:
        rating.getRouteRating() == Rating.RatingNumber.GOOD.getValue()
        rating.getFrequencyRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.getCleannessRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.getConditionRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.comment == "good"
    }
}
