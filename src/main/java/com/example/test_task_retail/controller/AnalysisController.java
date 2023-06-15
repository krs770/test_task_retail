package com.example.test_task_retail.controller;

import com.example.test_task_retail.entity.Shipment;
import com.example.test_task_retail.repository.PriceRepository;
import com.example.test_task_retail.repository.ShipmentRepository;
import com.example.test_task_retail.results.AnalysisFilter;
import com.example.test_task_retail.results.SalesAnalysisResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    private final ShipmentRepository shipmentRepository;
    private final PriceRepository priceRepository;

    public AnalysisController(ShipmentRepository shipmentRepository, PriceRepository priceRepository) {
        this.shipmentRepository = shipmentRepository;
        this.priceRepository = priceRepository;
    }

    @GetMapping("/sales")
    public List<SalesAnalysisResult> getSalesAnalysis() {
        return shipmentRepository.getSalesAnalysis();
    }

    @PostMapping("/sales")
    public List<Shipment> getFilteredSales(@RequestBody AnalysisFilter filter) {
        return shipmentRepository.getFilteredSales(filter.getNetworks(), filter.getProducts());
    }
}
