package ratebus.rating

import grails.testing.gorm.DomainUnitTest
import ratebus.rating.ConditionRating
import spock.lang.Specification

class ConditionRatingSpec extends Specification implements DomainUnitTest<ConditionRating> {

    ConditionRating rating

    def setup() {
        rating = new ConditionRating()
    }

    def cleanup() {
    }

    def "test create condition rating with GOOD RatingNumber"() {
        when:
        rating.ratingNumber = Rating.RatingNumber.GOOD
        rating.comment = "good"

        then:
        rating.getConditionRating() == Rating.RatingNumber.GOOD.getValue()
        rating.getFrequencyRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.getCleannessRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.getRouteRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.comment == "good"
    }
}
