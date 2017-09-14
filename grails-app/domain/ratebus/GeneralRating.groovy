package ratebus

class GeneralRating {

    List<Rating> ratings

    static constraints = {
    }

    def calculateGeneralRating() {
        ratings*.getRatingNumberValue().sum() / ratings.size()
    }
}
