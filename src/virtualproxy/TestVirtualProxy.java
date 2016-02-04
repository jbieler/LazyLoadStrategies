package virtualproxy;

import java.util.List;

import org.junit.Test;

public class TestVirtualProxy {

    @Test
    public void testVirtualProxy() {

        StudentMapper studentMapper = new StudentMapper();
        Student student = (Student) studentMapper.doLoad(1L);
        System.out.println("Student loaded with virtual classes");
        VirtualList courseVL = student.getCourses();
        List<DomainObject> courses = courseVL.getSource();
        for (DomainObject course : courses) {
            Course c = (Course) course;
            System.out.println(c.getId());
            System.out.println(c.getName());
        }


    }

}
