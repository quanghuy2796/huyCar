package com.vti.Huycar.service;

import com.vti.Huycar.Dto.AccessoryDto;
import com.vti.Huycar.form.AccessoryCreateForm;
import com.vti.Huycar.form.AccessoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    AccessoryDto create(AccessoryCreateForm form);

    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto update(Long id, AccessoryUpdateForm form);
    void deleteById(Long id);

}
