package com.demo.service;

import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.demo.exception.EmployeeException;
import com.demo.exception.EmployeeNotFoundException;
import com.demo.model.Employee;

@Transactional
@SpringBootTest()
@ExtendWith(SpringExtension.class)
@Tag("integration")
class DeleteEmployeeTest {

  @Autowired
  private EmployeeService employeeService;

  @Test
  @DisplayName("Delete an employee")
  void deleteEmployeeTest() throws EmployeeException, EmployeeNotFoundException {
    Employee employee = new Employee("fname-x", "lname-x", "emailx@exmaple.com");
    employee = employeeService.save(employee);
    assertTrue(employee.getId() > 0);

    int employeeId = employee.getId();
    employeeService.delete(employeeId);

    assertNull(employeeService.findOne(employeeId));
  }

}
