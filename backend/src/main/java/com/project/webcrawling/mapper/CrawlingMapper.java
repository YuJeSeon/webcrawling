package com.project.webcrawling.mapper;

import com.project.webcrawling.dto.ResponseDTO;
import com.project.webcrawling.entity.Crawling;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CrawlingMapper {
    @Mapping(target = "created_at", source = "created_at", dateFormat = "yyyy-MM-dd HH:mm:ss")
    ResponseDTO toResponseDTO(Crawling crawling);
}
