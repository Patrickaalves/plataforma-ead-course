package com.ead.course.service.impl;

import com.ead.course.model.LessonModel;
import com.ead.course.repositories.LessonRepository;
import com.ead.course.service.LessonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LessonServiceImpl implements LessonService {

    final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void delete(LessonModel lessonModel) {
        lessonRepository.delete(lessonModel);
    }
}
