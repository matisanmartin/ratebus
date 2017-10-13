package ratebus

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class GeneralRatingSpec extends Specification implements DomainUnitTest<GeneralRating> {

    List<Rating> ratings
    GeneralRating generalRating

    def setup() {
        ratings = [new ConditionRating(ratingNumber: Rating.RatingNumber.GOOD),
                   new ConditionRating(ratingNumber: Rating.RatingNumber.GOOD),
                   new ConditionRating(ratingNumber: Rating.RatingNumber.GOOD),
                   new ConditionRating(ratingNumber: Rating.RatingNumber.GOOD)
        ]

        generalRating = new GeneralRating(ratings: ratings, features: [])
    }

    def cleanup() {
    }

    void "test something"() {
        when:
        def avg = generalRating.calculateGeneralRating()

        then:
        avg == 4
    }
}
