package com.infinity.bytes.WhatsappApiService.service;


import com.infinity.bytes.WhatsappApiService.config.ClassMapper;
import com.infinity.bytes.WhatsappApiService.model.dto.request.WhatsappMessageDtoReq;
import com.infinity.bytes.WhatsappApiService.model.dto.request.WspMediaFileDtoReq;
import com.infinity.bytes.WhatsappApiService.model.entity.WhatsappFile;
import com.infinity.bytes.WhatsappApiService.repository.IWhatsappMediaRepository;
import com.infinity.bytes.WhatsappApiService.service.interfaces.AbstractMainService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class WhatsappMediaServiceImpl
        extends AbstractMainService<WhatsappFile> {

    private ClassMapper objMapper;
    private IWhatsappMediaRepository iWhatsappMediaRepository;

    public WhatsappMediaServiceImpl(ClassMapper objMapper, IWhatsappMediaRepository iWhatsappMediaRepository) {
        this.objMapper = objMapper;
        this.iWhatsappMediaRepository = iWhatsappMediaRepository;
    }

    public Optional<WhatsappFile> findByName(String name){
        log.debug("Buscando entidad por el nombre: {}", name);
        return iWhatsappMediaRepository.findByName(name);
    }
    public Optional<WhatsappFile> findByHashSha256(String shaHash){
        log.debug("Buscando entidad por el hash: {}", shaHash);
        return iWhatsappMediaRepository.findByHash(shaHash);
    }

    public Optional<WhatsappFile> findByUrlUpload(String URL){
        log.debug("Buscando entidad por la url UPLOAD: {}", URL);
        return iWhatsappMediaRepository.findByUploadUrl(URL);
    }
    public Page<WspMediaFileDtoReq> listInPage(Pageable pag){
        log.debug("Listando objectos por la cantidad de {} ", pag.getPageSize());
        Page<WhatsappFile> data =
                    iWhatsappMediaRepository.findAll(pag);


        return  data.map(this::convertEntityToDto);
    }

    /**
     * Encargado de hacer el mapeo de la clase entidad a clase dto
     * @param wspEntity Entidad a convertir a dto
     * @return Dto convertido
     */
    private WspMediaFileDtoReq convertEntityToDto(WhatsappFile wspEntity){
        return objMapper.modelMapper().map(wspEntity, WspMediaFileDtoReq.class);
    }



    public Integer createMedia(WspMediaFileDtoReq req){
        Integer idCreated  = 0;


        WhatsappFile filesConverted = objMapper
                .modelMapper().map(req, WhatsappFile.class);

        filesConverted.setDateCreation(new Date());
        filesConverted.setIsActive("S");

        log.debug("Entidad convertida para el guardado");
        iWhatsappMediaRepository.save(filesConverted);
        idCreated = filesConverted.getUuid();

        log.debug("Se ha creado la entidad retornando id {}" , idCreated);
        return idCreated;
    }





}
