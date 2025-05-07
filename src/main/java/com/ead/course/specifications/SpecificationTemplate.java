package com.ead.course.specifications;

import com.ead.course.model.CourseModel;
import com.ead.course.model.ModuleModel;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationTemplate {

    @And({
            @Spec(path = "courseLevel", spec = Equal.class),
            @Spec(path = "courseStatus", spec = Equal.class),
            @Spec(path = "name", spec = LikeIgnoreCase.class),
            @Spec(path = "userInstructor", spec = Equal.class),
    })
    public interface CourseSpec extends Specification<CourseModel> {}

    @And({
            @Spec(path = "title", spec = LikeIgnoreCase.class),
    })
    public interface ModuleSpec extends Specification<ModuleModel> {}

    public static Specification<CourseModel> courseLevel(String courseLevel) {

    }
}

