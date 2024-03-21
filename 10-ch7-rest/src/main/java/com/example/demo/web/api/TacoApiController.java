package com.example.demo.web.api;

import com.example.demo.Taco;
import com.example.demo.TacoOrder;
import com.example.demo.data.TacoRepository;
import com.example.demo.web.TacoProps;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
public class TacoApiController {

    private TacoRepository tacoRepository;

    private TacoProps tacoProps;

    public TacoApiController(TacoRepository tacoRepository, TacoProps tacoProps) {
        this.tacoRepository = tacoRepository;
        this.tacoProps = tacoProps;
    }

    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(0, tacoProps.getPageSize(), Sort.by("createdAt").descending());
        return tacoRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepository.findById(id);
        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }

}
