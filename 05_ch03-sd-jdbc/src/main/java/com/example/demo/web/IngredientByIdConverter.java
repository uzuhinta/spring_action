package com.example.demo.web;

import com.example.demo.Ingredient;
import com.example.demo.Ingredient.Type;
import com.example.demo.data.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private IngredientRepository ingredientRepo;
    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }


    @Override
    public Ingredient convert(String id) {
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ {}", ingredientRepo.findById(id).orElse(null));
        return ingredientRepo.findById(id).orElse(null);
    }
}
