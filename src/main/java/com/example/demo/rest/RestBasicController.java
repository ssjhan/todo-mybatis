package com.example.demo.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
//@ResponseBody // 응답을 할 때 html을 응답하는 것이 아니라 json으로 응답하겠다.
public class RestBasicController {

    @GetMapping("/china")
    public List<String> food() {
        List<String> foodList
                = Arrays.asList("마파두부", "꿔바로우", "마라탕");

        return foodList;
    }

    @GetMapping("/number")
    public int[] numbers() {
        int[] arr = {2, 4, 6, 8};
        return arr;
    }

    @GetMapping("/hobby")
    public Map<String, String> hobbies() {
        Map<String, String> hobbies = new HashMap<>();

        hobbies.put("운동", "축구");
        hobbies.put("여가", "산책");
        hobbies.put("맛집", "한우");

        return hobbies;
    }

    @GetMapping("/score")
    public Score score() {
        return new Score("김철수", 99, 50, 'B');
    }

    @GetMapping("/score-list")
    public List<Score> scoreList() {
        return Arrays.asList(
                new Score("김철수", 99, 50, 'B'),
                new Score("박영희", 55, 77, 'A'),
                new Score("송사리", 33, 88, 'D')
        );
    }

    @Setter @Getter @ToString
    @AllArgsConstructor
    public static class Score {

        private String name;
        private int javaExam;
        private int mathExam;
        private char grade;
    }

}







