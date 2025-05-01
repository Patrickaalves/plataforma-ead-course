package com.ead.course.service.impl;

import com.ead.course.repositories.LessonRepository;
import com.ead.course.service.LessonService;

public class LessonServiceImpl implements LessonService {

    final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
}
