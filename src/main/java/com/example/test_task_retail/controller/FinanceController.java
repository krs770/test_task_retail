package com.example.test_task_retail.controller;

import com.example.test_task_retail.entity.Price;
import com.example.test_task_retail.repository.PriceRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    private final PriceRepository priceRepository;

    public FinanceController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @PostMapping("/price")
    public Price save(@RequestBody Price price) {
        return priceRepository.save(price);
    }

//    @GetMapping("/price/{network}/{productCode}")
//    public Price getPrice(@PathVariable("network") String network, @PathVariable("productCode") int productCode) {
//        return priceRepository.findByNetworkNameAndProductCode(network, productCode)
//                .orElseThrow(() -> new RuntimeException("Not found by such network"));
//    }
//
//    @PutMapping("/price/{network}/{productCode}")
//    public Price updatePrice(@PathVariable("network") String network, @PathVariable("productCode") int productCode,
//                             Price price) {
//        Price price1 = getPrice(network, productCode);
//        priceRepository.setRegularPrice(price1);
//        return priceRepository.save(price1);
//    }
//
//    @DeleteMapping("/price/{network}/{productCode}")
//    public void deletePrice(@PathVariable("network") String network, @PathVariable("productCode") int productCode) {
//        Price price = getPrice(network, productCode);
//        priceRepository.delete(price);
//    }
}
