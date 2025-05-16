package com.ead.course.service;

import com.ead.course.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface UserService {
    Page<UserModel> findAll(Specification<UserModel> spec, Pageable page);
}
