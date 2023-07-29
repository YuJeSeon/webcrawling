package com.project.webcrawling.service;

import com.project.webcrawling.dto.ResponseDTO;
import com.project.webcrawling.entity.Crawling;
import com.project.webcrawling.mapper.CrawlingMapper;
import com.project.webcrawling.repository.CrawlingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WebService {
    private final CrawlingRepository crawlingRepository;
    private final CrawlingMapper crawlingMapper;
    private final LocalDate currentDate = LocalDate.now(); // 오늘 날짜로 설정

    public List<ResponseDTO> getLatestCrawling() {
        List<Crawling> latestCrawling = crawlingRepository.findLatestCrawlings();
        return mapToResponseDTOList(latestCrawling);
    }

    public List<ResponseDTO> getDailyCrawling(LocalDate date) { // 해당 날짜 데이터 전부
        return getCrawlingData(date, date.plusDays(1));
    }

    public List<ResponseDTO> getWeeklyCrawling() { // 해당 날짜가 속한 일주일(월~일)의 데이터 전부
        LocalDate startDate = currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1);
        LocalDate endDate = startDate.plusDays(7);
        return getCrawlingData(startDate, endDate);
    }

    public List<ResponseDTO> getMonthlyCrawling() { // 해당 날짜가 속한 달의 데이터 전부
        LocalDate startDate = currentDate.withDayOfMonth(1);
        LocalDate endDate = startDate.plusMonths(1);
        return getCrawlingData(startDate, endDate);
    }

    private List<ResponseDTO> getCrawlingData(LocalDate startDate, LocalDate endDate) {
        List<Crawling> crawlingList = crawlingRepository.findByCrawlingTimeRange(startDate, endDate);
        return mapToResponseDTOList(crawlingList);
    }

    private List<ResponseDTO> mapToResponseDTOList(List<Crawling> crawlingList) {
        return crawlingList.stream()
                .map(crawlingMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}

