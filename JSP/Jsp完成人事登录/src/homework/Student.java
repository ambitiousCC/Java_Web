package homework;

import java.io.Serializable;

public class Student implements Serializable{
	private String id;
	private String name;
	private String score;
	
	public Student(String id,String name,String score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	public String getID() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "Student[id="+id+",name="+name+",score="+score+"]";
	}
}
