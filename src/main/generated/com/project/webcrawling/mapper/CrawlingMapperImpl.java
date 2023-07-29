package com.project.webcrawling.mapper;

import com.project.webcrawling.dto.ResponseDTO;
import com.project.webcrawling.entity.Crawling;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-28T19:22:49+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class CrawlingMapperImpl implements CrawlingMapper {

    @Override
    public ResponseDTO toResponseDTO(Crawling crawling) {
        if ( crawling == null ) {
            return null;
        }

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setId( crawling.getId() );
        responseDTO.setType( crawling.getType() );
        responseDTO.setTitle( crawling.getTitle() );
        responseDTO.setUrl( crawling.getUrl() );

        return responseDTO;
    }
}
