package ratebus.rating

class RouteRating extends Rating {

    static constraints = {
        importFrom Rating
    }

    @Override
    def getRouteRating() {
        getRatingNumberValue()
    }
}
