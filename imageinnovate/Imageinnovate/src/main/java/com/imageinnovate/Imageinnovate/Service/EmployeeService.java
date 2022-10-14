package com.imageinnovate.Imageinnovate.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageinnovate.Imageinnovate.beans.Employee;
import com.imageinnovate.Imageinnovate.beans.TaxData;
import com.imageinnovate.Imageinnovate.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository repository;

	public Employee saveEmployee(Employee e) {
		Employee emp = repository.save(e);
		return emp;
	}

	public Employee getEmployeeById(Long id) {
		Employee e = repository.findById(id).get();
		
		if (e == null) {
			throw new RuntimeException("Employee not found");
		}
		
		return e;
	}

	/*
	 * No Tax for <=250000
	 * 
	 * 5% Tax for >250000 and <=500000
	 * 
	 * 10% Tax for >500000 and <=1000000
	 * 
	 * 20% Tax for >1000000
	 * 
	 **/
	public TaxData getTaxOfEmployee(Long id) {

		Employee e = repository.findById(id).get();
		
		if (e == null) {
			throw new RuntimeException("Employee not found");
		}
		
		Double salary = e.getSalary();
		double tax = 0;
		double cessAmount = 0;

		double paybleSal = calcEffectivSalary(e.getDOJ(), e.getSalary());

		if(paybleSal<=250000) {
			tax=0;
		}			
		else if(paybleSal<=500000) {
			tax=0.05*(paybleSal-250000);
		}
		else if(paybleSal<=1000000) {
			tax=(0.1*(paybleSal-500000))+(0.05*250000);
		}
		else {
			tax=(0.2*(paybleSal-1000000))+(0.1*500000)+(0.05*250000);
		}
		if (paybleSal >= 2500000) {
			cessAmount = paybleSal * 0.02;
		}

		TaxData td = new TaxData();
		td.setEmployeeID(e.getEmployeeID());
		td.setFirstName(e.getFirstName());
		td.setLastName(e.getLastName());
		td.setSalary(paybleSal);
		td.setTax(tax);
		td.setCessAmount(cessAmount);

		return td;
	}

	public static double calcEffectivSalary(Date date, double salary) {

		double monthlySal = salary / 12;
		double perDaySal = monthlySal / 30;

		int joiningMonth = date.getMonth()+1;
		int numOfDaysInFirstMonth = 30 - Integer.parseInt(date.toString().substring(8, 10));
		double paybleSal = (12 - joiningMonth) * monthlySal + numOfDaysInFirstMonth * perDaySal;
		
		return paybleSal;

	}

}
