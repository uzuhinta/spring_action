package com.example.demo.data;

import com.example.demo.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
}
