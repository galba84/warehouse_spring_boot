package com.warehouse.wh;

import com.warehouse.wh.Entity.Article;
import com.warehouse.wh.Entity.Location;
import com.warehouse.wh.Entity.StockItem;
import com.warehouse.wh.dao.ArticleDAO;
import com.warehouse.wh.dao.LocationDAO;
import com.warehouse.wh.dao.StockItemDAO;
import org.hibernate.exception.DataException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Random;


@RestController
public class MainController {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StockItemDAO stockItemDAO;
    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private LocationDAO locationDAO;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        StringBuilder sb = new StringBuilder();
        return "hello controller!";
    }

    @ResponseBody
    @GetMapping("/stockItems")
    String stockItems() {
        Iterable<StockItem> result = stockItemDAO.findAll();
        String resultString = "";
        for (StockItem item : result
        ) {
            resultString += "ITEM : " + item.toString() + System.lineSeparator();
        }
        return resultString;
    }

    @PostMapping("/stockItem")
    public ResponseEntity<StockItem> newStockItem() {
        Random random = new Random(1000);
        random.nextInt(500);

        StockItem stockItem = new StockItem();
        Iterable<Article> articles = articleDAO.findAll();
        stockItem.setLocation(new Location(random.nextInt(500) + 50, random.nextInt(50) + 10));

        stockItem.setArticle(articles.iterator().next());

        return new ResponseEntity<StockItem>(stockItemDAO.save(stockItem), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/stockItems/{id}")
    String one(@PathVariable Long id) {

        StockItem stockItem = stockItemDAO.findById(id)
                .orElseThrow(() -> new DataException("stockItem not found id: " + id, new SQLException()));
        return stockItem.toString();
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);


    }
}