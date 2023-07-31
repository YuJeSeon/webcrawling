package com.project.webcrawling.controller;

import com.project.webcrawling.dto.ResponseDTO;
import com.project.webcrawling.publicUse.SingleResponseDto;
import com.project.webcrawling.service.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WebController {
    private final WebService webService;

    @GetMapping("/crawling")
    public ResponseEntity<SingleResponseDto<List<ResponseDTO>>> getCrawling(@RequestParam(name = "type") String type,
                                                                            @RequestParam(name = "start_date", required = false) String startDateStr) {
        List<ResponseDTO> data;

        switch (type) {
            case "now":
                data = webService.getLatestCrawling();
                break;
            case "daily":
                LocalDateTime startDate = startDateStr != null ? LocalDateTime.parse(startDateStr).with(LocalTime.MIN) : LocalDateTime.now().with(LocalTime.MIN);
                data = webService.getDailyCrawling(startDate);
                break;
            case "weekly":
                data = webService.getWeeklyCrawling();
                break;
            case "monthly":
                data = webService.getMonthlyCrawling();
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new SingleResponseDto<>(data));
    }
}