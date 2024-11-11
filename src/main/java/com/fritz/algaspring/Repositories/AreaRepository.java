package com.fritz.algaspring.Repositories;

import com.fritz.algaspring.Entities.Area;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class AreaRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<Area> areaList() {
        TypedQuery<Area> query = manager.createQuery("from Area ", Area.class);

        return query.getResultList();
    }

    @Transactional
    public Area save(Area area) {
        return manager.merge(area);
    }
}