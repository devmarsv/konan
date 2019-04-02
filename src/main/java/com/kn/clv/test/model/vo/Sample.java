package com.kn.clv.test.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Sample implements java.io.Serializable{
  public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Sample [name=" + name + ", age=" + age + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
private static final long serialVersionUID = 999L;
  
  private String name;
  private int age;

  
}
