package com.warehouse.wh.init;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.warehouse.wh.Entity.Article;
import com.warehouse.wh.Entity.Location;
import com.warehouse.wh.Entity.StockItem;
import com.warehouse.wh.dao.ArticleDAO;
import com.warehouse.wh.dao.LocationDAO;
import com.warehouse.wh.dao.StockItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private StockItemDAO stockItemDAO;
    private ArticleDAO articleDAO;
    private LocationDAO locationDAO;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DataInit(StockItemDAO stockItemDAO, ArticleDAO articleDAO, LocationDAO locationDAO) {
        this.stockItemDAO = stockItemDAO;
        this.articleDAO = articleDAO;
        this.locationDAO = locationDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        StockItem stockItem = new StockItem();
        stockItem.setLocation(new Location(1, 1));
        stockItem.setArticle(new Article("Book"));
        stockItemDAO.save(stockItem);

        stockItem = new StockItem();
        stockItem.setLocation(new Location(2, 3));
        stockItem.setArticle(new Article("Disk"));
        stockItemDAO.save(stockItem);

        stockItem = new StockItem();
        stockItem.setLocation(new Location(1, 5));
        stockItem.setArticle(new Article("Cup"));
        stockItemDAO.save(stockItem);

    }

}