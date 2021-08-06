package com.B305.ogym.domain.users.ptStudent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PTStudentRepository extends JpaRepository<PTStudent,Long>,PTStudentRepositoryCustom {
    PTStudent findByEmail(String email);

}