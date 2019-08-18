package com.demo.service;

import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Transactional
@SpringBootTest()
@ExtendWith(SpringExtension.class)
@Tag("integration")
public class EmployeeServiceTest {

  @Autowired
  EmployeeService employeeService;

  @Test
  @DisplayName("Employee service should be autowired")
  public void employeeServiceShouldBePresetTest() {
    assertNotNull(employeeService);
  }
}
