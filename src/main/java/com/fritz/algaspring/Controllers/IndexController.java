package com.fritz.algaspring.Controllers;

import com.fritz.algaspring.Entities.Area;
import com.fritz.algaspring.Repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
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
    public ResponseEntity<?> areaById(@PathVariable long id) {
        Area area = areaRepository.areaById(id);
        if (area == null) {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Area ID, not exist or removed");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(area);
    }

    @PostMapping("/area")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Area saveArea(@RequestBody Area area) {
        return areaRepository.save(area);
    }

    @PutMapping("/area/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateArea(@PathVariable long id, @RequestBody Area area) {
        Area area1 = areaRepository.areaById(id);
        if (area == null) {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Area ID, not exist or removed");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        if (area.getName() != null) {
            area1.setName(area.getName());
        }

        if (area.getDescription() != null) {
            area1.setDescription(area.getDescription());
        }

        return ResponseEntity.ok().body(areaRepository.save(area1));
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