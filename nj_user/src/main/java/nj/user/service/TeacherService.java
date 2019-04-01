package nj.user.service;

import nj.user.dao.TeacherDao;
import nj.user.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class TeacherService {

	@Autowired
	private TeacherDao teacherDao;


	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Teacher> findAll() {
		return teacherDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Teacher> findSearch(Map whereMap, int page, int size) {
		Specification<Teacher> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return teacherDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Teacher> findSearch(Map whereMap) {
		Specification<Teacher> specification = createSpecification(whereMap);
		return teacherDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Teacher findById(String id) {
		return teacherDao.findById(id).get();
	}



	/**
	 * 修改
	 * @param teacher
	 */
	public void update(Teacher teacher) {
		teacherDao.save(teacher);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		teacherDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Teacher> createSpecification(Map searchMap) {

		return new Specification<Teacher>() {

			@Override
			public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}