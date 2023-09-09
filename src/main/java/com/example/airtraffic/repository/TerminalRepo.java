package com.example.airtraffic.repository;


import com.example.airtraffic.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalRepo extends JpaRepository<Terminal,Long> {

}
