package ratebus

class Rating {

    RatingNumber ratingNumber

    String comment

    static constraints = {
        ratingNumber nullable: false, blank: false
        ratingType nullable: false, blank: false
        generalRating nullable: false, blank: false
        comment nullable: true, blank: true
    }

    def getRatingNumberValue() {
        this.ratingNumber.getValue()
    }

    enum RatingNumber {
        VERY_BAD(1), BAD(2), REGULAR(3), GOOD(4), REALLY_GOOD(5)

        Integer value

        RatingNumber(Integer value){
            this.value = value
        }

        def getValue() {
            this.value
        }
    }

}
