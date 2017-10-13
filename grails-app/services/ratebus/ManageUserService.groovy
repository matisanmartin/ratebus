package ratebus

import grails.gorm.transactions.Transactional
import ratebus.user.User

@Transactional
class ManageUserService {

    def createUser(Map attrs) {
        User user = new User(attrs)
        user.create()
    }

    def editUser(Map attrs) {
        User user = User.get(attrs.get('username'))
        user.editAccount(attrs)
    }

    def deleteUser(String username) {
        User user = user.get(username)
        user.delete()
    }

}
