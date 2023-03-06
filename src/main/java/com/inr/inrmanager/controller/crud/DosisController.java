package com.inr.inrmanager.controller.crud;

import com.inr.inrmanager.dtos.DosisDto;
import com.inr.inrmanager.service.crud.DosisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inr.inrmanager.UriConstants.UriConstants.DOSIS_VALUE_BASE_URI;

@Slf4j
@RestController
@RequestMapping(DOSIS_VALUE_BASE_URI)
public class DosisController extends AbstractCrudController<DosisService, DosisDto>{
    public DosisController(DosisService service) {
        super(service);
    }
}
