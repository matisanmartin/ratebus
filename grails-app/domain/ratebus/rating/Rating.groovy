package ratebus.rating

import java.time.DayOfWeek


abstract class Rating  {

    RatingNumber ratingNumber

    String comment

    String hourSince

    String hourUnitl

    List<DayOfWeek> days;

    static constraints = {
        ratingNumber nullable: false, blank: false
        comment nullable: true, blank: true
    }

    def getRatingNumberValue() {
        this.ratingNumber.getValue()
    }

    enum RatingNumber {
        NO_RATING(0), VERY_BAD(1), BAD(2), REGULAR(3), GOOD(4), REALLY_GOOD(5)

        Integer value

        RatingNumber(Integer value){
            this.value = value
        }

        def getValue() {
            this.value
        }
    }

    def getCleannessRating() {
        RatingNumber.NO_RATING.getValue()
    }

    def getRouteRating() {
        RatingNumber.NO_RATING.getValue()
    }

    def getConditionRating() {
        RatingNumber.NO_RATING.getValue()
    }

    def getFrequencyRating() {
        RatingNumber.NO_RATING.getValue()
    }

}
