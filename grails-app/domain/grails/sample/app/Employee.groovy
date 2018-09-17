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

  /**
  * 勤続年数
  */
  public int serviceYears() {
    def today = new Date()
    return Math.max(0, today.year - this.joinedDate.year)
  }
}
