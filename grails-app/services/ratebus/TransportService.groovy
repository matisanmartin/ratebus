package ratebus

import grails.gorm.transactions.Transactional

@Transactional
class TransportService {

    def getTransport(Long transportId) {
        Transport.get(transportId)
    }
}
