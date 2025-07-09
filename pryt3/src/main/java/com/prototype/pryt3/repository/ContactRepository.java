package com.prototype.pryt3.repository;

import com.prototype.pryt3.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository <Contact, Long> {

}
