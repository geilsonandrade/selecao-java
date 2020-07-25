package com.indra.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.indra.api.domain.FuelHistory;
import com.indra.api.dto.FuelHistoryDTO;
import com.indra.api.services.FuelHistoryService;

@RestController
@RequestMapping(value = "/fuel_history")
public class FuelHistoryResource {

	@Autowired
	private FuelHistoryService service;

	@RequestMapping(method=RequestMethod.GET)
 	public ResponseEntity<List<FuelHistoryDTO>> findAll() {
		List<FuelHistory> list = service.findAll();
		List<FuelHistoryDTO> listDto = list.stream().map(x -> new FuelHistoryDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<FuelHistoryDTO> findById(@PathVariable long id) {
		FuelHistory obj = service.findById(id);
		return ResponseEntity.ok().body(new FuelHistoryDTO(obj));
	}

	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody FuelHistoryDTO objDto) {
		FuelHistory obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody FuelHistoryDTO objDto, @PathVariable long id) {
		FuelHistory obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
