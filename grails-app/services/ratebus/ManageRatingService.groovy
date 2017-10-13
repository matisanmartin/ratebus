package ratebus

import grails.gorm.transactions.Transactional

@Transactional
class ManageRatingService {

    def addNewRating(String username, Long transportId, GeneralRating newRating) {
        User user = User.get(username)
        Transport transport = Transport.get(transportId)
        transport.addGeneralRating(user, newRating)
    }

    def deleteRating(Long ratingId) {
        def ratingToDelete = GeneralRating.get(ratingId)
        ratingToDelete.delete()
    }

    def editRating(String username, Long transportId, GeneralRating editedRating) {
        User user = User.get(username)
        Transport transport = Transport.get(transportId)
        transport.editRating(user, editedRating)
    }
}