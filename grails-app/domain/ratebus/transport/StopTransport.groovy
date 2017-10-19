package ratebus.transport

class StopTransport extends Transport {

    protected List<Stop> stops

    static constraints = {
        importFrom Transport
    }

    def addStop(Stop stop) {
        if(!stops)
            stops = []
        else {
            if(stops.any { it -> it.name == stop.name})
                throw new Exception ("No se puede agregar una parada ya existente en la lista")
        }

        stops.add(stop)
    }

    def removeStop(Stop stop) {
        if(!stops)
            throw new Exception("No se puede elimniar la parada ya que no existe ninguna")

        stops.removeIf { it.name == stop.name }
    }
}
