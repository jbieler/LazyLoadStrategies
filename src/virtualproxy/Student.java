package virtualproxy;

public class Student extends DomainObject{
    private Long id;
    private VirtualList courses ;

    public Student(Long id) {
        this.id = id;
    }

    public VirtualList getCourses() {
        System.out.println("Student.getCourses");
        return courses;
    }

    public void setCourses(VirtualList courses) {
        this.courses = courses;
    }
}