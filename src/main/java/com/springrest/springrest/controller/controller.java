package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller
{
    @Autowired
    private CourseService courseService;

//    @GetMapping("/home")
//   public String home()
//   {
//       return "this is home page";
//
//   }
    //@RequestMapping(path="/courses",method=RequestMethod.GET)
    @GetMapping("/courses")
   public List<Course> getCourses()
   {
        return this.courseService.getCourses();
   }


    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //@PostMapping (path = "/courses",consumes="application/json")
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course)

    {
        return this.courseService.updateCourse(course);
    }

//    @DeleteMapping("/courses/{courseId}")
//    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
//    {
//        try
//        {
//            this.courseService.getCourse(Long.parseLong(courseId));
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch(Exception e)
//        {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id)
    {
        this.courseService.delete(id);
        return "redirect:/";
    }


}
