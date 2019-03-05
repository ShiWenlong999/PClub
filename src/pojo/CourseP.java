package pojo;

public class CourseP {
	private int id;
	private String course_name;
	private String price;
	private String teacher;
	private String date;
	private String desc1;
	private String desc2;
	private String p1;
	private String p2;
	private String p3;
	private int state;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getDesc2() {
		return desc2;
	}
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3 = p3;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", course_name=" + course_name + ", price=" + price + ", teacher=" + teacher
				+ ", date=" + date + ", desc1=" + desc1 + ", desc2=" + desc2 + ", p1=" + p1 + ", p2=" + p2 + ", p3="
				+ p3 + ", state=" + state + "]";
	}
	

}
