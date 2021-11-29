package com.springrest.springrest.services;

//import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseDao courseDao;
    // List<Course> list;

    public CourseServiceImpl()
    {
//        list=new ArrayList<>();
//        list.add(new Course(135,"Java Course"," basic java"));
//        list.add(new Course(4354,"Spring Boot"," creating rest Api using spring boot"));
    }

    @Override
    public List<Course> getCourses() {
//      return list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//      Course c=null;
//      for(Course course:list)
//      {
//        if(course.getId()==courseId)
//        {
//            c=course;
//            break;
//        }
//      }
//      return c;
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//       list.add(course);
//       return course;
        courseDao.save(course);
        return course;

    }

    @Override
    public Course updateCourse(Course course1) {
        // 1st way
//       list.forEach(e->{
//           if(e.getId()==course.getId())
//           {
//              e.setTitle(course.getTitle());
//              e.setDescription(course.getDescription());
//           }
//       });
//       return course;
        //  2nd way:
//        for(Course course:list)
//        {
//            if(course.getId()==course1.getId())
//            {
//                course.setTitle(course1.getTitle());
//                course.setDescription(course1.getDescription());
//            }
//        }
//        return course1;
        courseDao.save(course1);
        return course1;
    }

    @Override
    public void delete(long id)
    {
        Course entity = courseDao.getOne(id);
        courseDao.delete(entity);
    }


//    @Override
//    public void deleteCourse(long parseLong)
//    {
//     //  list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
//        Course entity= courseDao.getOne(parseLong);
//        courseDao.delete(entity);
//    }
}


