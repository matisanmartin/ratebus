package ratebus

interface RatingCalculator {

    def getCleannessRating()

    def getRouteRating()

    def getConditionRating()

    def getFrequencyRating()
}