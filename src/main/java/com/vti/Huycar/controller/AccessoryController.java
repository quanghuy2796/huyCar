package com.vti.Huycar.controller;


import com.vti.Huycar.Dto.AccessoryDto;
import com.vti.Huycar.form.AccessoryCreateForm;
import com.vti.Huycar.form.AccessoryUpdateForm;
import com.vti.Huycar.service.AccessoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
@CrossOrigin("*")
public class AccessoryController {
    private final AccessoryService accessoryService;

    @DeleteMapping("/api/v1/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        accessoryService .deleteById(id);
    }

    @PutMapping("/api/v1/accessories/{id}")
    public AccessoryDto update (@PathVariable("id") Long id,@RequestBody @Valid AccessoryUpdateForm form){
        return accessoryService.update(id, form);
    }

    @GetMapping("/api/v1/accessories")
    public Page<AccessoryDto> findAll(Pageable pageable){
        return accessoryService.findAll(pageable);
    }

    @PostMapping("/api/v1/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryDto create  (@RequestBody @Valid AccessoryCreateForm form){
        return accessoryService.create(form);
    }
}
