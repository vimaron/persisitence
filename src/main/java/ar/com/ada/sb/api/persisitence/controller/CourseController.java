package ar.com.ada.sb.api.persisitence.controller;

import ar.com.ada.sb.api.persisitence.model.dto.CourseDto;
import ar.com.ada.sb.api.persisitence.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired @Qualifier("courseServices")
    private CourseServices courseServices;

    @PostMapping({"/", ""})
    public ResponseEntity newCourse(@RequestBody @Valid CourseDto dto){

            courseServices.save(dto);

        return ResponseEntity.ok().body(null);
    }
}
