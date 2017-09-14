package ratebus

class Transport {

    protected Set<GeneralRating> allRatings

    static constraints = {
    }

    def getGeneralRating() {
       allRatings.collect { it.calculateGeneralRating() }.sum()/allRatings.size()
    }
}
