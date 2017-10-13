package ratebus

import grails.gorm.transactions.Transactional
import ratebus.transport.Transport

@Transactional
class RankingService {

    def getBestTransportOrderedByGeneralRating() {
        Transport.findAll().sort { -it.getGeneralRating() }
    }

    def getBestTransportsOrderedByCleannessRating() {
        Transport.findAll().sort { -it.getCleannesRating() }
    }

    def getBestTransportsOrderedByFrequencyRating() {
        Transport.findAll().sort { -it.getFrequencyRating() }
    }

    def getBestTransportsOrderedByCondition() {
        Transport.findAll().sort { -it.getConditionRating() }
    }

    def getBestTransportsOrderedByRoute() {
        Transport.findAll().sort { -it.getRouteRating() }
    }
}
