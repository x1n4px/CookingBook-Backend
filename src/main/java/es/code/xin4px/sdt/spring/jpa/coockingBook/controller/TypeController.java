package es.code.xin4px.sdt.spring.jpa.coockingBook.controller;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Converter.TypeConverter;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Type;
import es.code.xin4px.sdt.spring.jpa.coockingBook.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/type")
public class TypeController {

   @Autowired
   private TypeService typeService;

   @GetMapping("")
    public ResponseEntity<List<Type>> getAll() {
       return ResponseEntity.ok(typeService.getAll().stream().map(TypeConverter::toExternal).collect(Collectors.toList()));
   }




}
