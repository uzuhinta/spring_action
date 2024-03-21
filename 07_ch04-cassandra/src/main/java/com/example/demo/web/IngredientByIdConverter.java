package com.example.demo.web;

import com.example.demo.Ingredient;
import com.example.demo.Ingredient.Type;
import com.example.demo.IngredientUDT;
import com.example.demo.data.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class IngredientByIdConverter implements Converter<String, IngredientUDT> {
    private IngredientRepository ingredientRepo;
    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }


    @Override
    public IngredientUDT convert(String id) {
        log.info("@@@@@@@@@@@@@@@@@@@@");
        log.info("@@@@@@@@@@@@@@@@@@@@ {}", ingredientRepo.findById(id).orElse(null));
        Optional<Ingredient> optIngredient =  ingredientRepo.findById(id);
        if (optIngredient.isPresent()) {
            return new IngredientUDT(optIngredient.get().getName(), optIngredient.get().getType());
        }
        return  null;
    }
}
