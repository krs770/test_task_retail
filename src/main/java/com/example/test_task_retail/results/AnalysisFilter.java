package com.example.test_task_retail.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisFilter {
    private List<String> networks;
    private List<Integer> products;

}
