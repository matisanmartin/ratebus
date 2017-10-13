package ratebus

class GeneralRating {

    List<Rating> ratings

    List<Feature> features

    static final FEATURE_ACCUM_FACTOR = 16

    static constraints = {
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
