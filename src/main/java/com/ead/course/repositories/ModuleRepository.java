package com.ead.course.repositories;

import com.ead.course.model.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID>, JpaSpecificationExecutor<ModuleModel> {

//    @EntityGraph(attributePaths = {"course"})
//    ModuleModel findByTitle(String title);

    @Query(value = "select * from tb_modules where course_course_id = :courseId ", nativeQuery = true)
    List<ModuleModel> findAllModulesIntoCourse(@Param("courseId") UUID courseId);

    @Query(value = "select * from tb_modules where course_course_id = :courseId  and module_id = :moduleId", nativeQuery = true)
    Optional<ModuleModel> findModuleIntoCourse(UUID courseId, UUID moduleId);
}
