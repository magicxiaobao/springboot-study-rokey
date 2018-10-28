package com.rokey.springboot.study;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rokey.springboot.study.entity.User;
import com.rokey.springboot.study.jpa.Worker;
import com.rokey.springboot.study.jpa.WorkerRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WorkerTest {

	@Autowired
	private WorkerRepository workerRepository;

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private RedisTemplate<String, Worker> workerRedisTemplate;

	@Before
	public void setUp() {

		workerRepository.deleteAll();
		workerRepository.flush();
		cacheManager.getCache("workers").clear();
	}

	@Test
	@Rollback
	public void test() throws Exception {

		// 创建10条记录
		workerRepository.save(new Worker("AAA", 10));
		workerRepository.save(new Worker("BBB", 20));
		workerRepository.save(new Worker("CCC", 30));
		workerRepository.save(new Worker("DDD", 40));
		workerRepository.save(new Worker("EEE", 50));
		workerRepository.save(new Worker("FFF", 60));
		workerRepository.save(new Worker("GGG", 70));
		workerRepository.save(new Worker("HHH", 80));
		//测试不标准输入 抛异常情况下，事务能否起作用
		//		workerRepository.save(new Worker("XXXXXXXXXxxxxxxxxx", 0));
		workerRepository.save(new Worker("III", 90));
		workerRepository.save(new Worker("JJJ", 100));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, workerRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的Worker
		Assert.assertEquals(60, workerRepository.findByName("FFF").getAge().longValue());

		// 测试findWorker, 查询姓名为FFF的Worker
		Assert.assertEquals(60, workerRepository.findWorker("FFF").getAge().longValue());

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的Worker
		Assert.assertEquals("FFF", workerRepository.findByNameAndAge("FFF", 60).getName());

		// 测试删除姓名为AAA的Worker
		workerRepository.delete(workerRepository.findByName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, workerRepository.findAll().size());

	}

	@Test
	public void testCache() {

		workerRepository.save(new Worker("xiaobao", 34));
		workerRepository.flush();
		Worker xiaobao1 = workerRepository.findByName("xiaobao");
		Worker xiaobao2 = workerRepository.findByName("xiaobao");
		Assert.assertEquals(34, xiaobao2.getAge().intValue());
		Worker workerBeforeChangedAge = workerRedisTemplate.opsForValue().get("workers::xiaobao");
		Assert.assertEquals(34, workerBeforeChangedAge.getAge().intValue());
		xiaobao2.setAge(55);
		workerRepository.save(xiaobao2);
		workerRepository.flush();
		Worker xiaobao3 = workerRepository.findByName("xiaobao");
		System.out.println(xiaobao3.getAge());
		Assert.assertEquals(55, xiaobao3.getAge().intValue());
		//验证CacheInput 标签是否生效，修改数据后 数据库和缓存都更新
		Worker workerAfterChangedAge = workerRedisTemplate.opsForValue().get("workers::xiaobao");
		Assert.assertEquals(55, workerAfterChangedAge.getAge().intValue());

	}

	@Test
	public void testClear() {

		System.out.println("do Nothing");
		Cache cache = cacheManager.getCache("workers");
		ValueWrapper valueWrapper = cache.get("workers::xiaobao");
		Assert.assertNull(valueWrapper);
	}


}