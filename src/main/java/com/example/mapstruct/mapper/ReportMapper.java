package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.ReportDto;
import com.example.mapstruct.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ReportMapper {

    Report toModel(ReportDto dto);

//    @Mapping(target = "field", ignore = true)
    @Mapping(source = "values", target = "field")
    ReportDto toDto(Report model);

}
