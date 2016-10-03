package com.ssa.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id //id, first_name, last_name, gpa, sat, major_id
	@Column(name="id")
	int id;
	
	@Column(name="first_name")
	String first_name;
	
	@Column(name="last_name")
	String last_name;
	
	@Column(name="sat")
	int sat;
	
	@Column(name="gpa")
	double gpa;
	

	
	public Student(){}
	public Student(String first_name, String last_name, int sat, double gpa) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.sat = sat;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getSat() {
		return sat;
	}
	public void setSat(int sat) {
		this.sat = sat;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
}
