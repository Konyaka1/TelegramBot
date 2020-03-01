package com.telegram.bot.controllers;

import com.telegram.bot.requests.CityForm;
import com.telegram.bot.service.ICityService;
import com.telegram.bot.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class InformationController {

    @Autowired
    private ICityService cityService;

    @GetMapping
    @Secured("ADMIN")
    public Response getAll() {
        return Response.setSuccess(cityService.getAll());
    }

    @PostMapping
    @Secured("ADMIN")
    public Response addCity(@RequestBody CityForm cityForm) {
        return Response.setSuccess(cityService.addCity(cityForm));
    }

    @PutMapping
    @Secured("ADMIN")
    public Response updateCity(@RequestBody CityForm cityForm) {
        return Response.setSuccess(cityService.updateCity(cityForm));
    }

    @DeleteMapping
    @Secured("ADMIN")
    public Response deleteCity(int id) {
        return Response.setSuccess(cityService.deleteCity(id));
    }

    @ExceptionHandler({HibernateException.class})
    public Response handlerException() {
        return Response.setError("Illegal arguments for database");
    }
}
