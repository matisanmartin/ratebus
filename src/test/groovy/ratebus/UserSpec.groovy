package ratebus

import grails.testing.gorm.DomainUnitTest
import org.yaml.snakeyaml.introspector.MissingProperty
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    User user

    def setup() {
        user = new User()
    }

    def cleanup() {
    }

    void "test create user with null username"() {
        when:
        user.username == null

        then:
        !user.validate(['username'])

    }

    void "test create user with email not formatted"() {
        when:
        user.email = 'asdasdasd'

        then:
        !user.validate(['email'])
    }

    void "test create user with email with correct format"() {
        when:
        user.email = 'matias.sanmartin@redb.ee'

        then:
        user.validate(['email'])
    }

    void "test create user with password with less than 8 characters"() {
        when:
        user.password = 'asd'

        then:
        !user.validate(['password'])
    }

    void "test create user with a valid password"() {
        when:
        user.password = '12345678'

        then:
        user.validate(['password'])
    }


}
