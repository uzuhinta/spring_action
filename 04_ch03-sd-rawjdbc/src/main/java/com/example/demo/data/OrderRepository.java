package com.example.demo.data;

import com.example.demo.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
