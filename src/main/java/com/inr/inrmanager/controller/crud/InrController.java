package com.inr.inrmanager.controller.crud;

import com.inr.inrmanager.dtos.InrDto;
import com.inr.inrmanager.service.crud.InrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inr.inrmanager.UriConstants.UriConstants.INR_VALUE_BASE_URI;

@Slf4j
@RestController
@RequestMapping(INR_VALUE_BASE_URI)
public class InrController extends AbstractCrudController<InrService, InrDto> {

    public InrController(InrService service) {
        super(service);
    }


}
