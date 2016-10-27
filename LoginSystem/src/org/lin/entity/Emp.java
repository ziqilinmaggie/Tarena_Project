package org.lin.entity;

import java.io.Serializable;

public class Emp implements Serializable {
	private Integer id;
	private String name;
	private Double salary;
	private Integer age;
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", age=" + age + "]";
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getSalary() {
		return salary;
	}
	public Integer getAge() {
		return age;
	}
	
}
