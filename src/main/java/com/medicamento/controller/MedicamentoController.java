package com.medicamento.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicamento.entity.Medicamento;
import com.medicamento.service.MedicamentoService;
import com.medicamento.util.Constantes;

@RestController
@RequestMapping("/actividad4/medicamento")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentoController {

	@Autowired
	private MedicamentoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listaMedicamento() {
		List<Medicamento> lista = service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>>insertaMedicamento(@RequestBody Medicamento obj){
		
		Map<String, Object>salida= new HashMap<>();
		try {
			Medicamento objSalida =  service.insertaActualizaMedicamento(obj);
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
