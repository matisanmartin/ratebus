package ratebus.rating

class CleannessRating extends Rating {

    static constraints = {
        importFrom Rating
    }

    @Override
    def getCleannessRating() {
        getRatingNumberValue()
    }
}
