package com.jrp.pma.dao;

import java.util.List;

import com.jrp.pma.dto.ChartData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	//CrudRepository has a findAll() but returns an Iterable<T>. So we need to define
	// our own method that returns a List<Project>
	@Override
	public List<Project> findAll();


	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " +
									"FROM project " +
									"GROUP BY stage")
	public List<ChartData> getProjectStatus();
}
