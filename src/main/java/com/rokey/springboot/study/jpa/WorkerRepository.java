package com.rokey.springboot.study.jpa;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * @author chenyuejun
 */
@CacheConfig(cacheNames = "workers")
public interface WorkerRepository extends JpaRepository<Worker, Long> {

	/**
	 *
	 * @param name
	 * @return
	 */
	@Cacheable(key = "#p0")
	Worker findByName(String name);

	@CachePut(key = "#p0.name")
	@Override
	Worker save(Worker worker);


	Worker findByNameAndAge(String name, Integer age);

	@Query("from Worker w where w.name=:name")
	Worker findWorker(@Param("name") String name);

}
