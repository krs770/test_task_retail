package com.example.test_task_retail.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalesAnalysisResult {
    private String network;
    private String category;
    private int month;
    private int unitsSoldAtRegularPrice;
    private int unitsSoldAtPromoPrice;
    private double promoSalesPercentage;
}
