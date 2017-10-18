package ratebus.transport

import groovy.time.TimeCategory
import ratebus.rating.GeneralRating
import ratebus.user.User
import ratebus.user.Address

class Transport {

    protected String name

    protected String ownerCompany

    protected String contactNumber

    protected Address address

    protected String country

    protected String city

    protected Set<GeneralRating> allRatings

    static constraints = {
        name nullable: false, blank: false, unique: true
        ownerCompany nullable: false, blank: false, unique: true
        address nullable: false
        country nullable: false, blank: false
        city nullable: false, blank: false
    }

    def getCleannessRating() {
        allRatings.collect({ it.getCleannessRating() }).sum() / allRatings.size()
    }

    def getConditionRating() {
        allRatings.collect { it.getConditionRating() }.sum() / allRatings.size()
    }

    def getRouteRating() {
        allRatings.collect { it.getRouteRating() }.sum() / allRatings.size()
    }

    def getFrequencyRating() {
        allRatings.collect { it.getFrequencyRating() }.sum() / allRatings.size()
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
}
