package com.medicamento.service;

import java.util.List;

import com.medicamento.entity.Medicamento;

public interface MedicamentoService {

	public List<Medicamento>listaMedicamento();
	public Medicamento insertaActualizaMedicamento(Medicamento obj);
	
}
