package ar.com.ada.sb.api.persisitence.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CourseDto implements Serializable {
    private Long id;
    private String name;
    private String code;
    private BigDecimal price;
    private String description;

    public CourseDto (Long id, String name, String code, BigDecimal price, String description){
        this.id=id;
        this.name=name;
        this.code=code;
        this.price=price;
        this.description=description;
    }


}
