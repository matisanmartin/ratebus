package ratebus.transport

class BranchLine {

    String description

    String shortDescription

    static constraints = {
        shortDescription nullable: false, blank: false
        description nullable: true, blank: true
    }
}
