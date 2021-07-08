package com.payrolljdbc;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollServiceTest {
	 @Test
	    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEnteries(){
	        EmployeePayrollData[] arrayOfEmps = {
	                new EmployeePayrollData(1, "piyush", 30000.0),
	                new EmployeePayrollData(2, "rahul", 36000.0),
	                new EmployeePayrollData(3, "shubham", 40000.0)
	        };
	        EmployeePayrollService employeePayrollService;
	        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
	        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
	        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
	        long enteries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
	        Assert.assertEquals(3, enteries);
	    }

	    @Test
	    public void givenEmployeePayrollDBWhenRetrivedShouldMatchEmployeeCount() {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
	        Assert.assertEquals(3, employeePayrollData.size());
	    }
}
