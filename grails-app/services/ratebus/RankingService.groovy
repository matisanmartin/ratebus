package ratebus

import grails.gorm.transactions.Transactional
import ratebus.transport.Transport
import ratebus.rating.Rating.RatingType

@Transactional
class RankingService {

    def getBestTransportOrderedByGeneralRating() {
        Transport.findAll().sort { -it.getGeneralRating() }
    }

    def getBestTransportsOrderedByCleannessRating() {
        Transport.findAll().sort { -it.getRatingByType(RatingType.CLEANNESS) }
    }

    def getBestTransportsOrderedByFrequencyRating() {
        Transport.findAll().sort { -it.getRatingByType(RatingType.FREQUENCY) }
    }

    def getBestTransportsOrderedByConditionRating() {
        Transport.findAll().sort { -it.getRatingByType(RatingType.CONDITION) }
    }

    def getBestTransportsOrderedByRoute() {
        Transport.findAll().sort { -it.getRatingByType(RatingType.ROUTE) }
    }
}
