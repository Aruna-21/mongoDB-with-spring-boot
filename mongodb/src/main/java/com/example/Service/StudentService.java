package com.example.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id){
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted";
    }
    public List<Student> getStudentsByName(String name){
        return studentRepository.getByName(name);
    }
    public Student getStudentsByNameAndEmail(String name, String email){
        return studentRepository.findByNameAndEmail(name,email);
    }

    public List<Student> getStudentsByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name,email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNo-1,pageSize);
        return studentRepository.findAll(pageable).getContent() ;
    }

    public List<Student> allWithSorting() {
        Sort sort = Sort.by(Sort.Direction.DESC,"name");
        return studentRepository.findAll(sort);
    }
}
