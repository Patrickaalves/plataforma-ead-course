package com.ead.course.service;

import com.ead.course.dtos.LessonRecordDto;
import com.ead.course.model.LessonModel;
import com.ead.course.model.ModuleModel;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonService {
    void delete(LessonModel lessonModel);

    LessonModel save(ModuleModel moduleModel, @Valid LessonRecordDto lessonRecordDto);

    List<LessonModel> findAllLessonsIntoModule(UUID moduleId);

    Optional<LessonModel> findLessonIntoModule(UUID moduleId, UUID lessonId);

    LessonModel update(LessonRecordDto lessonRecordDto, LessonModel lessonModel);
}
