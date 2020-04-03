package ar.com.ada.sb.api.persisitence.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor
@Entity @Table(name = "course")
public class Course implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name_chance", nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 10, unique = true)
    private String code;

    @NonNull
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @NonNull
    @Column(name = "description")
    private String description;

    public Course(Long id){
        this.id=id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id.equals(course.id) &&
                name.equals(course.name) &&
                code.equals(course.code) &&
                price.equals(course.price) &&
                description.equals(course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, price, description);
    }
}
