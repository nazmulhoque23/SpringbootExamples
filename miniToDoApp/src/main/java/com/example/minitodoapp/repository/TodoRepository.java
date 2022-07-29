package com.example.minitodoapp.repository;

import com.example.minitodoapp.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    /*Page<Todo> findByPublished(boolean published, Pageable pageable);
    Page<Todo> findByTitleContaining(String title, Pageable pageable);*/
}
