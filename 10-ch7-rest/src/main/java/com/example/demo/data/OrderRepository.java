package com.example.demo.data;

import com.example.demo.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
