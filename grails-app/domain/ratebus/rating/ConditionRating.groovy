package ratebus.rating

class ConditionRating extends Rating {

    static constraints = {
        importFrom Rating
    }

    @Override
    def getConditionRating() {
        getRatingNumberValue()
    }
}
