package ratebus.rating

import grails.testing.gorm.DomainUnitTest
import ratebus.rating.FrequencyRating
import spock.lang.Specification

class FrequencyRatingSpec extends Specification implements DomainUnitTest<FrequencyRating> {

    FrequencyRating rating

    def setup() {
        rating = new FrequencyRating()
    }

    def cleanup() {
    }

    def "test create frequency rating with GOOD RatingNumber"() {
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
