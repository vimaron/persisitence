package ar.com.ada.sb.api.persisitence.services;

import ar.com.ada.sb.api.persisitence.exception.ApiEntityError;
import ar.com.ada.sb.api.persisitence.exception.BusinessLogicException;
import ar.com.ada.sb.api.persisitence.model.dto.CourseDto;
import ar.com.ada.sb.api.persisitence.model.entity.Course;
import ar.com.ada.sb.api.persisitence.model.mapper.CourseMapper;
import ar.com.ada.sb.api.persisitence.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("courseServices")
public class CourseServices implements Services<CourseDto>{

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public CourseServices(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }


    @Override
    public CourseDto save(CourseDto dto) throws  BusinessLogicException{

        Optional<Course> byCode = courseRepository.findByCode(dto.getCode());
        byCode.ifPresent(course -> {
            ApiEntityError apiEntityError = new ApiEntityError(
                    "Course", "AlreadyExists", "The Course Code" + course.getCode()
                    + "is already assigned"
            );
            throw new BusinessLogicException("course already exists", HttpStatus.CONFLICT, apiEntityError);
        });


        Course courseToSave = courseMapper.toEntity(dto);

        Course savedEntity = courseRepository.save(courseToSave);


        CourseDto savedDto = courseMapper.toDto(savedEntity);

        return savedDto;
    }

    @Override
    public List<CourseDto> findAll() {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
