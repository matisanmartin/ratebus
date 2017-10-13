package ratebus

import grails.gorm.transactions.Transactional
import ratebus.transport.Transport

@Transactional
class TransportService {

    def getTransport(Long transportId) {
        Transport.get(transportId)
    }
}
