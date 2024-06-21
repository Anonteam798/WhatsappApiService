package com.infinity.bytes.WhatsappApiService.controller;


import com.infinity.bytes.WhatsappApiService.config.ClassMapper;
import com.infinity.bytes.WhatsappApiService.model.dto.ResponseDto;
import com.infinity.bytes.WhatsappApiService.model.dto.request.BussinessDtoReq;
import com.infinity.bytes.WhatsappApiService.model.entity.Bussiness;
import com.infinity.bytes.WhatsappApiService.service.BussinessServiceImpl;
import com.infinity.bytes.WhatsappApiService.util.QuickResponseUtil;
import jdk.jshell.execution.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bussiness")
@Slf4j
public class BussinessController {
    private BussinessServiceImpl bussinessService;

    private ClassMapper classMapper;


    public BussinessController(BussinessServiceImpl bussinessService, ClassMapper classMapper) {
        this.bussinessService = bussinessService;
        this.classMapper = classMapper;
    }


    @GetMapping("/find/{ruc}")
    public ResponseEntity<?> getBussinessByRuc(@PathVariable String ruc){
        log.debug("GET Buscar ruc con el valor: " + ruc);

        List<Bussiness> found = bussinessService.findByRuc(ruc);

        log.debug("Se han encontrado: "+ found.size() + " items");
        return  QuickResponseUtil
                .returnResponse(
                        ResponseDto
                                .builder()
                                .success(!found.isEmpty())
                                .message(found.isEmpty() ? "No se han encontrado registros":"Registro encontrado")
                                .errors(null)
                                .data(bussinessService.convertEntityToDto(found))
                                .responseCode(found.isEmpty() ?404: 200)
                                .build()
                );
    }

    @PostMapping("/new")
    public ResponseEntity<?>
            createNewBussiness(@RequestBody BussinessDtoReq newBussiness){

        log.debug("Nueva entidad entrante:  " + newBussiness.toString());
        boolean isCreated = false;
        Bussiness converted = classMapper.modelMapper().map(newBussiness
            , Bussiness.class);

        if (!newBussiness.getLogoBase64().isEmpty()){
            converted.setLogo(newBussiness.getLogoBase64().getBytes(StandardCharsets.UTF_8));
        }


        log.debug("Buscando por negocios ya existentes");
        List<Bussiness> found = bussinessService
                .findByRucOrRazonSocialContaining(newBussiness.getRuc(), newBussiness.getRazonSocial());

        if (found.isEmpty()){
            log.debug("No se han encontrado negocios con ese ruc o razon social, guardando");

            log.debug("Guardando entidad");
             found =  List.of(bussinessService.createItem(converted));
             isCreated = true;
            log.debug("Nueva entidad covertida y guardada:  " + converted.toString());
        }


        return  QuickResponseUtil
                .returnResponse(
                        ResponseDto
                                .builder()
                                .success(true)
                                .message(isCreated? "Negocio registrado con exito":"Ya existen registros con ese ruc o razon social")
                                .errors(null)
                                .data(bussinessService.convertEntityToDto(found))
                                .responseCode(200)
                                .build()
                );

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBussiness(){
        log.debug("Get: Buscando negocios activos");
        Collection<Bussiness> foundActiveBussines
                = this.bussinessService.getAllActiveBussiness();

        log.debug(String.format("Cantidad de negocios encontrados: %s" , foundActiveBussines.size()));

            return QuickResponseUtil
                    .returnResponse(
                           ResponseDto
                                   .builder()
                                   .success(true)
                                   .message(foundActiveBussines.isEmpty()?"No se han encontrado datos": "Datos existentes")
                                   .data(foundActiveBussines)
                                   .errors(null)
                                   .responseCode(foundActiveBussines.isEmpty()?404:200)
                                   .build()
                    );



    }


}
