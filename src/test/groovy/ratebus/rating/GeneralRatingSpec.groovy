package ratebus.rating

import grails.testing.gorm.DomainUnitTest
import ratebus.rating.ConditionRating
import ratebus.rating.GeneralRating
import ratebus.rating.Rating
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

    void "test calculate general rating is 4 if all the ratings ar good"() {
        when:
        def avg = generalRating.calculateGeneralRating()

        then:
        avg == 4
    }
}
