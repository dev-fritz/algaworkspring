package com.fritz.algaspring.Controllers;

import com.fritz.algaspring.Entities.Area;
import com.fritz.algaspring.Repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private AreaRepository areaRepository;

    @GetMapping("/area")
    @ResponseStatus(HttpStatus.OK)
    public List<Area> listAreas() {
        return areaRepository.areaList();
    }

    @PostMapping("/area")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Area saveArea(@RequestBody Area area) {
        return areaRepository.save(area);
    }
}