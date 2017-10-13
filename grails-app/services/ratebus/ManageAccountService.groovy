package ratebus

import grails.gorm.transactions.Transactional

@Transactional
class ManageAccountService {

    def createAccount(Map attrs) {
        User user = new User(attrs)
        user.create()
    }

    def editAccount(Map attrs) {
        User user = User.get(attrs.get('username'))
        user.editAccount(attrs)
    }

    def deleteAccount(String username) {
        User user = user.get(username)
        user.delete()
    }

}
