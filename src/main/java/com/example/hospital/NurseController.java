package com.example.hospital;

import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NurseController {
	 private ArrayList<Nurse> nurses;
	 //ArrayList

	   // Constructor que inicializa la lista de enfermeros
	    public NurseController() {
	        nurses = new ArrayList<>();
	        nurses.add(new Nurse("Alberto", "password1"));
	        nurses.add(new Nurse("Maria", "password2"));
	        nurses.add(new Nurse("Juan", "password3"));
	    }
//	
//
	    @PostMapping("/login")
	    public ResponseEntity <Boolean> login(@RequestParam String user, @RequestParam String password) {

	        for (Nurse nurse : nurses) {
	            
	            // Verificamos si el usuario y la contraseña coinciden
	            if (nurse.user().equals(user) && nurse.password().equals(password)) {
	                return ResponseEntity.ok(true); 
	            }
	        }
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false); 

	    }
}
