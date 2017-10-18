package ratebus.rating

import grails.testing.gorm.DomainUnitTest
import ratebus.rating.CleannessRating
import spock.lang.Specification

class CleannessRatingSpec extends Specification implements DomainUnitTest<CleannessRating> {

    CleannessRating rating
    def setup() {
        rating = new CleannessRating()
    }

    def cleanup() {
    }

    def "test create cleanness rating with GOOD RatingNumber"() {
        when:
        rating.ratingNumber = Rating.RatingNumber.GOOD
        rating.comment = "good"

        then:
        rating.getCleannessRating() == Rating.RatingNumber.GOOD.getValue()
        rating.getFrequencyRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.getConditionRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.getRouteRating() == Rating.RatingNumber.NO_RATING.getValue()
        rating.comment == "good"
    }
}
