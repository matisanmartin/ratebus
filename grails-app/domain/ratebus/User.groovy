package ratebus


class User {

    String username

    Long dni

    String name

    String surname

    Date birthday

    String email

    String password

    Gender gender

    List<Transport> qualifiedTransports

    def editAccount(Map map) {
        properties = map
    }

    enum Gender {
        M,F,X
    }

    static constraints = {
        username unique: true, nullable: false, blank: false
        email unique: true, nullable: false, blank: false, email: true
        password nullable: false, blank: false, minSize: 8, password: true
        dni blank: false, nullable: false
        name blank: false, nullable: false
        surname blank: true, nullable: true
        birthday blank: true, nullable: true
        gender blank: true, nullable: true
        qualifiedTransports nullable: true
    }


}
