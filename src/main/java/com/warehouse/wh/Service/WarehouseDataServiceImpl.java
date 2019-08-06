package com.warehouse.wh.Service;

import com.warehouse.wh.Entity.Article;
import com.warehouse.wh.Entity.StockItem;
import com.warehouse.wh.dao.ArticleDao;
import com.warehouse.wh.dao.LocationDao;
import com.warehouse.wh.dao.StockItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseDataServiceImpl implements WarehouseDataService {
    @Autowired
    private StockItemDao stockItemDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private LocationDao locationDAO;

    @Transactional
    public List<StockItem> getStockItems() {
        Iterable<StockItem> myIterator = stockItemDao.findAll();
        List<StockItem> myList = new LinkedList<>();
        for (StockItem si : myIterator
        ) {
            myList.add(si);
        }
        return myList;
    }

    @Transactional
    public List<Article> getArticles() {
        Iterable<Article> myIterator = articleDao.findAll();
        List<Article> myList = new LinkedList<>();
        for (Article article : myIterator
        ) {
            myList.add(article);
        }
        return myList;
    }

    @Transactional
    public Article save(Article article) {
        return articleDao.save(article);
    }

    @Transactional
    public StockItem save(StockItem stockItem) {
        return stockItemDao.save(stockItem);
    }

    @Transactional
    public Optional<StockItem> getStockItemById(Long id) {
        Optional<StockItem> employee = stockItemDao.findById(id);
        return employee;
    }

}
