package jana60.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "teachers")
public class Teachers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String officeAddress;
	private Integer officeNumber;
	
	@ManyToMany
	@JoinTable(name="course_teacher",joinColumns = { @JoinColumn(name = "teacher_id") },inverseJoinColumns = { @JoinColumn(name = "course_id") })
	private List<Courses> teachersCourses;
	
	//Getter and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Integer getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(Integer officeNumber) {
		this.officeNumber = officeNumber;
		
	}
	public List<Courses> getTeachersCourses() {
		return teachersCourses;
	}
	public void setTeachersCourses(List<Courses> teachersCourses) {
		this.teachersCourses = teachersCourses;
	}
	
	
	
	
	
}