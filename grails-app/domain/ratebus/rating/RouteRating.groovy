package ratebus.rating

class RouteRating extends Rating {

    static constraints = {
        importFrom Rating
    }

    @Override
    def getCleannessRating() {
        0
    }

    @Override
    def getRouteRating() {
        getRatingNumberValue()
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
