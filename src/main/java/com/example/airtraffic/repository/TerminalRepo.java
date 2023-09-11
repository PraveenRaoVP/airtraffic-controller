package com.example.airtraffic.repository;


import com.example.airtraffic.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface TerminalRepo extends JpaRepository<Terminal, Integer> {

}
