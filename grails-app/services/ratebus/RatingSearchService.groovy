package ratebus

import grails.gorm.transactions.Transactional

@Transactional(readOnly = true)
class RatingSearchService {

    def getAllRatingsForGivenUser(String username) {
        User user = User.get(username)
        GeneralRating.findAllByUser(user).sort { a,b -> b.creationDate <=> a.creationDate}
    }

}
