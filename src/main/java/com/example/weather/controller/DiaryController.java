package com.example.weather.controller;

import com.example.weather.domain.Diary;
import com.example.weather.service.DiaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiaryController {
    private final DiaryService diaryService;

    @ApiOperation(value = "일기 텍스트와 날씨 이용, DB에 일기 저장", notes = "이것은 노트")
    @PostMapping("/create/diary")
    void createDiary(
            @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text
            ){
        diaryService.createDiary(date, text);
    }

    @ApiOperation("선택한 날짜의 모든 일기 데이터 호출")
    @GetMapping("/read/diary")
    List<Diary> readDiary(
            @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date
    ) {
       return diaryService.readDiary(date);
    }

    @ApiOperation("선택한 기간중의 모든 일기 데이터 호출")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(
            @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 첫번째날", example = "2023-03-01") LocalDate startDate,
            @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 마지막날", example = "2023-03-04") LocalDate endDate
    ) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @ApiOperation("해당 날짜 일기 제목, 내용 수정")
    @PutMapping("/update/diary")
    void updateDiary(
            @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text
    ) {
        diaryService.updateDiary(date, text);
    }

    @ApiOperation("해당 날짜 일기 삭제")
    @DeleteMapping("/delete/diary")
    void deleteDiary(
            @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        diaryService.deleteDiary(date);
    }
}
