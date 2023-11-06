package com.vti.Huycar.service;

import com.vti.Huycar.Dto.AccessoryDto;
import com.vti.Huycar.entity.Accessory;
import com.vti.Huycar.entity.Car;
import com.vti.Huycar.form.AccessoryCreateForm;
import com.vti.Huycar.form.AccessoryUpdateForm;
import com.vti.Huycar.repository.AccessoryRepository;
import com.vti.Huycar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccessoryServiceImpl implements AccessoryService {
    private final AccessoryRepository accessoryRepository;

    private final CarRepository carRepository;

    private final ModelMapper modelMapper;

    @Override
    public AccessoryDto create(AccessoryCreateForm form) {
        var accessory = modelMapper.map(form, Accessory.class);
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        var car = carRepository.findById(pk).get();
        accessory.setCar(car);
        var savedAccessory = accessoryRepository.save(accessory);
        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }

    @Override
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepository.findAll(pageable)
                .map(accessory -> modelMapper.map(accessory, AccessoryDto.class));
    }

    @Override
    public AccessoryDto update(Long id, AccessoryUpdateForm form) {
        var accessory = accessoryRepository.findById(id).get();
        modelMapper.map(form, accessory);
        var savedAccessory = accessoryRepository.save(accessory);
        return modelMapper.map(savedAccessory, AccessoryDto.class);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}
