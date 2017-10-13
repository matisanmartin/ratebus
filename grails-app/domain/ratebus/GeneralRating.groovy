package ratebus

class GeneralRating {

    Long id

    List<Rating> ratings

    List<Feature> features

    Date creationDate

    User user

    static final FEATURE_ACCUM_FACTOR = 16

    static constraints = {
        creationDate nullable: false
    }

    def calculateGeneralRating() {
        getRatingAccumulated() + getFeaturesAccumulated()
    }

    def getRatingAccumulated() {
        ratings*.getRatingNumberValue().sum() / ratings.size()
    }

    def getFeaturesAccumulated() {
        features.count { it.isPresent() }/FEATURE_ACCUM_FACTOR
    }
}
