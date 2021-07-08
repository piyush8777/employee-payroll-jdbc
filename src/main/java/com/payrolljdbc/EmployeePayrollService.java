/**
 * ************************************************************************* 
 * Purpose: to retrieve the Employee Payroll from the Database  
 *                     
 * @author Piyush Shaw
 * @version 1.0
 * @since 05-07-2021
 * **************************************************************************
 */


package com.payrolljdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	 public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

	    private List<EmployeePayrollData> employeepayrollList;

	    public EmployeePayrollService() {
	    }

	    public EmployeePayrollService(List<EmployeePayrollData> employeepayrollList) {
	        this.employeepayrollList = employeepayrollList;
	    }

	    private void readEmployeePayrollData(Scanner consoleInputReader) {
	        System.out.println("Enter Employee ID: ");
	        int id = consoleInputReader.nextInt();
	        System.out.println("Enter Employee Name: ");
	        String name = consoleInputReader.next();
	        System.out.println("Enter Employee Salary: ");
	        double salary = consoleInputReader.nextDouble();
	        employeepayrollList.add(new EmployeePayrollData(id, name, salary));
	    }

	    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService){
	        if (ioService.equals(IOService.DB_IO))
	            this.employeepayrollList = new EmployeePayrollDBService().readData();
	        return employeepayrollList;

	    }

	    public void writeEmployeePayrollData(IOService ioService) {
	        if (ioService.equals(IOService.CONSOLE_IO))
	            System.out.println("\n Writting Employee payroll to Console\n" + employeepayrollList);
	        else if (ioService.equals(IOService.FILE_IO))
	            new FileIOService().writeData(employeepayrollList);
	    }

	    public void printData(IOService ioService) {
	        if (ioService.equals(IOService.FILE_IO))
	            new FileIOService().printData();
	    }

	    public long countEntries(IOService ioService) {
	        if (ioService.equals(IOService.FILE_IO))
	            return new FileIOService().countEntries();
	        return 0;
	    }
	
}
