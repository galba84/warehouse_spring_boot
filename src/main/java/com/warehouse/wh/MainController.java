package com.warehouse.wh;

import com.warehouse.wh.Entity.Article;
import com.warehouse.wh.Entity.Location;
import com.warehouse.wh.Entity.StockItem;
import com.warehouse.wh.Service.WarehouseDataServiceImpl;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;


@RestController
public class MainController {

    @Autowired
    private WarehouseDataServiceImpl warehouseDataService;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        StringBuilder sb = new StringBuilder();
        return "hello controller!";
    }

    @ResponseBody
    @GetMapping("/stockItems")
    String stockItems() {
        List<StockItem> result = warehouseDataService.getStockItems();
        StringBuffer sb = new StringBuffer();
        for (StockItem item : result
        ) {
            sb.append("ITEM : " + item.toString() + System.lineSeparator());
        }
        return sb.toString();
    }

    @PostMapping("/stockItem")
    public ResponseEntity<StockItem> newStockItem() {
        Random random = new Random(1000);
        random.nextInt(500);
        StockItem stockItem = new StockItem();
        Iterable<Article> articles = warehouseDataService.getArticles();
        stockItem.setLocation(new Location(random.nextInt(500) + 50, random.nextInt(50) + 10));
        stockItem.setArticle(articles.iterator().next());
        return new ResponseEntity<StockItem>(warehouseDataService.save(stockItem), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/stockItems/{id}")
    String one(@PathVariable Long id) {
        StockItem stockItem = warehouseDataService.getStockItemById(id)
                .orElseThrow(() -> new DataException("stockItem not found id: " + id, new SQLException()));
        return stockItem.toString();
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);


    }
}