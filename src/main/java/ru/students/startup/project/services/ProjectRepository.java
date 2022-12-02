package ru.students.startup.project.services;

public interface ProjectRepository<T> {

    void store(T book);
}
