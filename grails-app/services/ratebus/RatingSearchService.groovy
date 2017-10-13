package ratebus

import grails.gorm.transactions.Transactional
import ratebus.rating.GeneralRating
import ratebus.rating.Rating
import ratebus.transport.Transport
import ratebus.user.User

@Transactional(readOnly = true)
class RatingSearchService {

    def getAllRatingsForGivenUser(String username) {
        User user = User.get(username)
        GeneralRating.findAllByUser(user).sort { a, b -> b.creationDate <=> a.creationDate}
    }

    def getTransportRating(Long transportId) {
        Transport.get(transportId).allRatings
    }

    def getRating(Long ratingId) {
        Rating.get(ratingId)
    }
}
