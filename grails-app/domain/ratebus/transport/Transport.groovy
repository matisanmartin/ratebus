package ratebus.transport

import groovy.time.TimeCategory
import ratebus.company.Company
import ratebus.rating.GeneralRating
import ratebus.rating.Rating.RatingType
import ratebus.user.User

class Transport {

    protected String name

    protected Company company

    protected Set<GeneralRating> allRatings

    protected Set<BranchLine> branchLines

    static constraints = {
        name nullable: false, blank: false
        allRatings nullable: true
        company nullable: false
    }

    def getRatingByType(RatingType type) {
        def ratingsByType = allRatings.collect { it.getRatingByType(type) }
        ratingsByType.collect { it.getRatingNumberValue() }.sum() / ratingsByType.size()
    }

    def getGeneralRating() {
        allRatings.collect { it.calculateGeneralRating() }.sum() / allRatings.size()
    }

    def addGeneralRating(User user, GeneralRating generalRating) {
        if (!allRatings)
            allRatings = new ArrayList<GeneralRating>()

        def existingRatingForUser = allRatings.find { it.user == user }

        if (existingRatingForUser)
            throw new Exception("Existing rating in last 30 days, cannot ")

        generalRating.user = user
        allRatings.add(generalRating)
    }

    def editRating(User user, GeneralRating generalRating) {
        def existingRatingIn15Days = allRatings.find {
            TimeCategory.minus(new Date(), it.creationDate).days <= 30 && it.user == user
        }

        if (existingRatingIn15Days)
            throw new Exception("Existing rating in last 15 days, cannot edit")

        generalRating.user = user
        allRatings.add(generalRating)
    }

    def getLine() {
        ""
    }

    def getAllLines() {
        []
    }
}
