package com.fritz.algaspring.Controllers;

import com.fritz.algaspring.Entities.Area;
import com.fritz.algaspring.Repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class IndexController {

    private final AreaRepository areaRepository;

    public IndexController(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @GetMapping("/area")
    @ResponseStatus(HttpStatus.OK)
    public List<Area> listAreas() {
        return areaRepository.areaList();
    }

    @GetMapping("/area/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Area areaById(@PathVariable long id) {
        Area area = areaRepository.areaById(id);
        if (area == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area ID, not exist or removed");
        }
        return area;
    }

    @PostMapping("/area")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Area saveArea(@RequestBody Area area) {
        return areaRepository.save(area);
    }

    @DeleteMapping("/area/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArea(@PathVariable long id) {
        Area area = areaRepository.areaById(id);
        if (area == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Area ID, not exist or removed");
        }
        areaRepository.delete(area);
    }
}