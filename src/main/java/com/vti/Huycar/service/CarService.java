package com.vti.Huycar.service;

import com.vti.Huycar.Dto.CarDto;
import com.vti.Huycar.entity.Car;
import com.vti.Huycar.form.CarCreateForm;
import com.vti.Huycar.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CarService {
    void deleteById(Car.PrimaryKey pk);
    CarDto update(CarUpdateForm form);
    Page<CarDto> findAll(Pageable pageable);

    CarDto create(CarCreateForm form);
}
