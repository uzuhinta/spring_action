package com.example.demo.data;

import com.example.demo.Taco;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    List<Taco> findAll( Pageable pageable);
}
