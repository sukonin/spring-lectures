package com.epam.core.lecture_7.jpaExample.springDataJpaRepository;

import com.epam.core.lecture_7.jpaExample.domain.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
