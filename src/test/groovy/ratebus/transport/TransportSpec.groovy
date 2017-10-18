package ratebus.transport

import grails.testing.gorm.DomainUnitTest
import ratebus.rating.CleannessRating
import ratebus.rating.ConditionRating
import ratebus.rating.FrequencyRating
import ratebus.rating.GeneralRating
import ratebus.rating.Rating
import ratebus.rating.RouteRating
import ratebus.transport.Transport
import spock.lang.Specification

class TransportSpec extends Specification implements DomainUnitTest<Transport> {

    Transport transport

    List<GeneralRating> generalRatings

    List<Rating> ratings

    def setup() {
        ratings = [new CleannessRating(ratingNumber: Rating.RatingNumber.GOOD),
                   new RouteRating(ratingNumber: Rating.RatingNumber.GOOD),
                   new FrequencyRating(ratingNumber: Rating.RatingNumber.GOOD),
                   new ConditionRating(ratingNumber: Rating.RatingNumber.GOOD)
        ]

        def generalRating = new GeneralRating(ratings: ratings)
        generalRating.features = []
        generalRatings = [generalRating]

        transport = new Transport(allRatings: generalRatings)

    }

    def cleanup() {
    }

    void "test calculate general rating of a transport who has an avg of 4 should return 4"() {
        when:
        def totalAvg = transport.getGeneralRating()

        then:
        totalAvg == 4
    }
}
