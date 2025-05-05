package com.ead.course.service;

import com.ead.course.dtos.ModuleRecordDto;
import com.ead.course.model.CourseModel;
import com.ead.course.model.ModuleModel;
import jakarta.validation.Valid;

public interface ModuleService {
    void delete(ModuleModel moduleModel);

    ModuleModel save(@Valid ModuleRecordDto moduleRecordDto, CourseModel courseModel);
}
