package ar.com.ada.sb.api.persisitence.model.mapper;

import ar.com.ada.sb.api.persisitence.model.dto.CourseDto;
import ar.com.ada.sb.api.persisitence.model.entity.Course;

@Mapper(componentModel = "spring", uses = {})
public interface CourseMapper extends DataMapper<Course, CourseDto> {

    Course toEntity(CourseDto dto);
    CourseDto toDto(Course entity);

}
