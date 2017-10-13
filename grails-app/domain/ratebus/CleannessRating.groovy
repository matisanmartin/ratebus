package ratebus

class CleannessRating extends Rating {

    static constraints = {
        importFrom Rating
    }

    @Override
    def getCleannessRating() {
        getRatingNumberValue()
    }

    @Override
    def getRouteRating() {
        0
    }

    @Override
    def getConditionRating() {
        0
    }

    @Override
    def getFrequencyRating() {
        0
    }
}
