package ratebus

class ConditionRating extends Rating {

    static constraints = {
        importFrom Rating
    }

    @Override
    def getCleannessRating() {
        0
    }

    @Override
    def getRouteRating() {
        0
    }

    @Override
    def getConditionRating() {
        getRatingNumberValue()
    }

    @Override
    def getFrequencyRating() {
        0
    }
}
