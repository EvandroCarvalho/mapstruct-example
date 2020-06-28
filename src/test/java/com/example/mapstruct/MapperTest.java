//package com.example.mapstruct;
//
//import com.example.mapstruct.dto.ReportDto;
//import com.example.mapstruct.entity.Report;
//import com.example.mapstruct.mapper.ReportMapper;
//import com.example.mapstruct.mapper.ReportMapperImpl;
//import java.util.Collections;
//import java.util.UUID;
//import java.util.stream.Collectors;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@ExtendWith(MockitoExtension.class)
//public class MapperTest {
//
//    ReportMapper reportMapper = new ReportMapperImpl();
//
//
//    @Test
//    public void testmapper() {
//        ReportDto dto = ReportDto.builder().uuid(UUID.randomUUID().toString()).build();
//        Report report = Report.builder().uuid(UUID.randomUUID().toString()).values(Collections.EMPTY_LIST).build();
//
//        reportMapper.toModel(dto);
//        reportMapper.toDto(report);
//
//    }
//}
