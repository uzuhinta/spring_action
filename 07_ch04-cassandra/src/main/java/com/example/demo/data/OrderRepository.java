package com.example.demo.data;

import com.example.demo.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
}
