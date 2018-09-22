package grails.sample.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmployeeServiceSpec extends Specification {

  EmployeeService employeeService
  SessionFactory sessionFactory

  private Employee setupValidData() {
    return new Employee(name: 'nanashi', department: 'IT Solutions',
                        gender: 'other', birth: new Date('1999/01/01'), joinedDate: new Date('2019/04/01'),
                        payment: new Long(120000), note: "").save(flush: true, failOnError: true)
  }

  private Long setupData() {
    new Employee(name: 'john doe', department: 'Human Resources',
                 gender: 'other', birth: new Date('1999/01/01'), joinedDate: new Date('2018/04/01'),
                 payment: new Long(100000), note: "").save(flush: true, failOnError: true)
    new Employee(name: 'alice', department: 'Sales',
                 gender: 'female', birth: new Date('1981/02/03'), joinedDate: new Date('2018/04/01'),
                 payment: new Long(150000), note: "").save(flush: true, failOnError: true)
    new Employee(name: 'bob', department: 'IT Solutions',
                 gender: 'male', birth: new Date('1955/11/11'), joinedDate: new Date('1990/04/01'),
                 payment: new Long(300000), note: "").save(flush: true, failOnError: true)
    new Employee(name: 'charlie', department: 'Sales',
                 gender: 'male', birth: new Date('1977/7/7'), joinedDate: new Date('2000/04/01'),
                 payment: new Long(280000), note: "").save(flush: true, failOnError: true)
    Employee employee = setupValidData()
    employee.id
  }

  void "test get"() {
    setupData()

    expect:
    employeeService.get(1) != null
  }

  void "test list"() {
    setupData()

    when:
    List<Employee> employeeList = employeeService.list(max: 2, offset: 2)

    then:
    employeeList.size() == 2
  }

  void "test count"() {
    setupData()

    expect:
    employeeService.count() == 5
  }

  void "test delete"() {
    Long employeeId = setupData()

    expect:
    employeeService.count() == 5

    when:
    employeeService.delete(employeeId)
    sessionFactory.currentSession.flush()

    then:
    employeeService.count() == 4
  }

  void "test save"() {
    when:
    Employee employee = setupValidData()
    employeeService.save(employee)

    then:
    employee.id != null
  }
}
