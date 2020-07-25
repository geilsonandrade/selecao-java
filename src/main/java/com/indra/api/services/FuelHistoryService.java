package com.indra.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.api.domain.FuelHistory;
import com.indra.api.dto.FuelHistoryDTO;
import com.indra.api.repositories.FuelHistoryRepository;
import com.indra.api.services.exception.ObjectNotFoundException;

@Service
public class FuelHistoryService {

	@Autowired
	private FuelHistoryRepository repo;

	public List<FuelHistory> findAll() {
		return repo.findAll();
	}

	public FuelHistory findById(long id) {
		Optional<FuelHistory> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public FuelHistory insert(FuelHistory obj) {
		return repo.save(obj);
	}

	public void delete(long id) {
		findById(id);
		repo.deleteById(id);
	}

	public FuelHistory update(FuelHistory obj) {
		FuelHistory newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(FuelHistory newObj, FuelHistory obj) {
		newObj.setRegion(obj.getRegion());
		newObj.setState(obj.getState());
		newObj.setMunicipality(obj.getMunicipality());
		newObj.setResale(obj.getResale());
		newObj.setCnpj(obj.getCnpj());
		newObj.setProduct(obj.getProduct());
		newObj.setCollectionData(obj.getCollectionData());
		newObj.setSaleValue(obj.getSaleValue());
		newObj.setPurchaseValue(obj.getPurchaseValue());
		newObj.setUnitMeasure(obj.getUnitMeasure());
		newObj.setFlag(obj.getFlag());
	}

	public FuelHistory fromDTO(FuelHistoryDTO objDto) {
		return new FuelHistory(objDto.getId(), objDto.getRegion(), objDto.getState(), objDto.getMunicipality(), objDto.getResale(),
				objDto.getCnpj(), objDto.getProduct(), objDto.getCollectionData(), objDto.getSaleValue(), objDto.getPurchaseValue(), objDto.getUnitMeasure(),
				objDto.getFlag());
	}
}
