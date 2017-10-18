package ratebus.rating

import ratebus.feature.Feature
import ratebus.transport.BranchLine
import ratebus.transport.Transport
import ratebus.user.User

class GeneralRating {

    Long id

    List<Rating> ratings

    List<Feature> features

    Date creationDate

    User user

    BranchLine branchLine

    static final FEATURE_ACCUM_FACTOR = 16

    static constraints = {
        creationDate nullable: false
        ratings nullable: false
        user nullable: false
        branchLine nullable: true
    }

    def calculateGeneralRating() {
        getRatingAccumulated() + getFeaturesAccumulated()
    }

    def getRatingAccumulated() {
        ratings*.getRatingNumberValue().sum() / ratings.size()
    }

    def getFeaturesAccumulated() {
        features.count { it.isPresent() } / FEATURE_ACCUM_FACTOR
    }

    def getCleannessRating() {
        ratings.collect{ it.getCleannessRating() }.sum() / ratings.size()
    }

    def getConditionRating() {
        ratings.collect { it.getConditionRating() }.sum() / ratings.size()
    }

    def getFrequencyRating() {
        ratings.collect { it.getFrequencyRating() }.sum() / ratings.size()
    }

    def getRouteRating() {
        ratings.collect { it.getRouteRating() }.sum() / ratings.size()
    }

}
