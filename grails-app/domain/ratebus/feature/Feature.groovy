package ratebus.feature

class Feature {

    Boolean present
    FeatureType type

    static constraints = {
    }

    def isPresent() {
        return present
    }

    enum FeatureType {
        WIFI, AIR_CONDITIONING, DOUBLE_UNIT, HEATING, SEAT_BELT
    }
}
