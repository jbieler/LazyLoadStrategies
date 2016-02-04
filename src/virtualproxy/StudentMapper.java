package virtualproxy;

import java.util.ArrayList;
import java.util.List;


public class StudentMapper {

    public static class CourseLoader implements VirtualListLoader {
        private Long id;

        public CourseLoader(Long id) {
            this.id = id;
        }

        @Override
        public List<DomainObject> load() {
            System.out.println("Actually load classes");
            // Load the course using the
            // student id supplier. Now returning dummy
            List<DomainObject> courses = new ArrayList<DomainObject>();
            Course c1 = new Course();
            c1.setId(1L);
            c1.setName("Mgmt");
            courses.add(c1);
            Course c2 = new Course();
            c2.setId(2L);
            c2.setName("IT");
            courses.add(c2);
            return courses;
        }
    }

    protected DomainObject doLoad(Long id) {
        Student result = new Student(id);
        result.setCourses(new VirtualList(new CourseLoader(id)));
        return result;
    }
}
