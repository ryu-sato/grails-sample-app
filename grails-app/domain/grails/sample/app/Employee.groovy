package grails.sample.app

class Employee {

  String name
  String department
  String gender
  Date birth
  Date joinedDate
  Long payment
  String note

  static constraints = {
    name blank: false, unique: true
    department blank: false
    gender blank: false, inList: ['male', 'female', 'other']
    birth blank: false
    joinedDate blank: false
    payment min: new Long(0), blank: false
    note blank: true
  }

  public int serviceYears() {
    def today = new Date()
    def duration = today - this.joinedDate
    if (duration < 0) {
      return 0
    }
    def serviceYears = Math.floor(duration / 365)
  }
}
