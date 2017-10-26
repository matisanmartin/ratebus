package ratebus.rating

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class GeneralRatingSpec extends Specification implements DomainUnitTest<GeneralRating> {

    List<Rating> ratings
    GeneralRating generalRating

    def setup() {
        ratings = [new Rating(ratingNumber: Rating.RatingNumber.GOOD),
                   new Rating(ratingNumber: Rating.RatingNumber.GOOD),
                   new Rating(ratingNumber: Rating.RatingNumber.GOOD),
                   new Rating(ratingNumber: Rating.RatingNumber.GOOD)
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
