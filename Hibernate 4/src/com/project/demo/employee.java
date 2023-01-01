package com.project.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee")
public class employee {
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="slno")
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc",strategy = "increment")
	private int slno;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="salary")
	private int salary;
	@Override
	public String toString() {
		return "employee [slno=" + slno + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary="
				+ salary + "]";
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public employee( String name, int age, String gender, int salary) {
		super();
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

}
