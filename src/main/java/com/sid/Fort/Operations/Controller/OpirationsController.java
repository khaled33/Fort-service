package com.sid.Fort.Operations.Controller;

import com.sid.Fort.Operations.Entity.Operations;
import com.sid.Fort.Operations.Service.IOperatiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OpirationsController {



    @Autowired
    @Qualifier("v2")
    private IOperatiosService iOperatiosService;

    @GetMapping("/Operation/{id}")
    public ResponseEntity<Operations> getOperationsById(@PathVariable Long id) {
        Operations rest = iOperatiosService.getOperationsById(id);
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }

    @GetMapping("/Operations/user/{id_user}")
    public ResponseEntity<List<Operations>> getAllOperations(@PathVariable Long id_user) {
        return new ResponseEntity<>(iOperatiosService.getAllOperations(id_user), HttpStatus.OK);
    }
    @GetMapping("/OperationDesignation/{id}")

    public String getDesignationOpirationById(@PathVariable Long id) {
        return iOperatiosService.getDesignationOpirationById(id);
    }
    @PostMapping("/Operation")
    public ResponseEntity<Operations> AddOperations(@RequestBody Operations Operations) {

        Operations rest = iOperatiosService.AddOperations(Operations);

        return new ResponseEntity<>(rest, HttpStatus.CREATED);
    }

    @PutMapping("/Operation/{id}")
    public ResponseEntity<Operations> UpdateOperations(@RequestBody Operations operations, @PathVariable Long id) {
        operations.setId(id);
        return new ResponseEntity<>(iOperatiosService.UpdateOperations(operations, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/Operation/{id}")
    public ResponseEntity<Void> DeleteOperations(@PathVariable Long id) {
        iOperatiosService.DeleteOperations(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/Operation/Countrie/{country_id}/DnfbpsSectors/{profession_id}/user/{id_User}")
    public ResponseEntity<Operations> AddOperations(@RequestBody Operations operations,
                                                    @PathVariable Long country_id,
                                                    @PathVariable Long  id_User,
                                                    @PathVariable Long profession_id
    ) {
        return new ResponseEntity<>(iOperatiosService.AddOperations(operations, country_id,id_User, profession_id), HttpStatus.CREATED);
    }
}
