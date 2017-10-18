package ratebus.rating

class FrequencyRating extends Rating {

    static constraints = {
        importFrom Rating
    }

    @Override
    def getConditionRating() {
        getRatingNumberValue()
    }
}
