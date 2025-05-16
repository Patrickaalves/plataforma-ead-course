package com.ead.course.specifications;

import com.ead.course.model.CourseModel;
import com.ead.course.model.LessonModel;
import com.ead.course.model.ModuleModel;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;
import java.util.UUID;

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

    @And({
            @Spec(path = "title", spec = LikeIgnoreCase.class),
    })
    public interface LessonSpec extends Specification<LessonModel> {}

    public static Specification<ModuleModel> moduleCourseId(final UUID courseId) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<CourseModel> course = query.from(CourseModel.class);
            Expression<Collection<ModuleModel>> courseModules = course.get("modules");
            return cb.and(
                 cb.equal(course.get("courseId"), courseId),
                 cb.isMember(root, courseModules)
            );
        };
    }

    // Isso aqui serve para me trazer todos lessons que estao dentro do module e esses modules é buscado pelo param moduleId
    public static Specification<LessonModel> lessonModuleId(final UUID moduleId) {
        return (lessonModelRoot, query, cb) -> {
            query.distinct(true);
            Root<ModuleModel> module = query.from(ModuleModel.class);
            Expression<Collection<LessonModel>> moduleLessons = module.get("lessons");
            return cb.and(
                 cb.equal(module.get("moduleId"), moduleId),
                 cb.isMember(lessonModelRoot, moduleLessons)
            );
        };
    }

    public static Specification<CourseModel> courseUserId(final UUID userId) {
//        return (root, query, cb) -> {
//            query.distinct(true);
//            Join<CourseModel, CourseUserModel> courseUser = root.join("courseUsers");
//            return cb.equal(courseUser.get("userId"), userId);
//        };
        return null;
    }

    public static Specification<LessonModel> teste() {
        return (root, query, cb) -> {

        String title = "teste";
        String description = "description";

        // select * from module
        Root<ModuleModel> module = query.from(ModuleModel.class);

        // prepare WHERE clause
        // WHERE firstname like '%ali%'
        Predicate firstNamePredicate = cb.like(module.get("title"), "%" + title + "%");
        Predicate lastNamePredicate = cb.like(module.get("name"), "%" + description + "%");
        Predicate orPredicate = cb.or(firstNamePredicate, lastNamePredicate);
        // => final query ==> select * from module where title like '%teste%' or lastname like '%description%'

        query.where(orPredicate);

        return null;
        };
    }
}

