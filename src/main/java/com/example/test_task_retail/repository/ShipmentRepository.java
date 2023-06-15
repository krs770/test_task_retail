package com.example.test_task_retail.repository;

import com.example.test_task_retail.entity.Shipment;
import com.example.test_task_retail.results.SalesAnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    /**
     * выгрузка фактов продаж с учётом признака промо, он должен возвращать все справочные поля:
     * сеть, категория, месяц, факт продаж в штуках по базовой цене, факт продаж по промо цене, доля продаж по промо, %.
     * @return
     */
    @Query(value = "SELECT s.network, p.category, MONTH(s.day), " +
            "SUM(CASE WHEN s.promoIndicator = 'REGULAR' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN s.promoIndicator = 'PROMO' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN s.promoIndicator = 'PROMO' THEN 1 ELSE 0 END) / COUNT(*) * 100 " +
            "FROM Shipments s " +
            "JOIN Customers c ON s.deliveryAddress = c.address " +
            "JOIN Products p ON s.productCode = p.productCode " +
            "GROUP BY s.network, p.category, MONTH(s.day)", nativeQuery = true)
    List<SalesAnalysisResult> getSalesAnalysis();

    /**
     * выгрузка фактов по дням, согласно фильтрации по списку наименований сетей и списку продуктов
     * @param networks
     * @param products
     * @return
     */
    @Query(value = "SELECT s " +
            "FROM Shipments s " +
            "JOIN Customers c ON s.customer.address = c.address " +
            "JOIN Products p ON s.product.productCode = p.productCode " +
            "WHERE c.networkName IN :networks AND p.productCode IN :products", nativeQuery = true)
    List<Shipment> getFilteredSales(@Param("networks") List<String> networks, @Param("products") List<Integer> products);
}

