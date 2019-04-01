package nj.user.dao;

import nj.user.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface TeacherDao extends JpaRepository<Teacher,String>,JpaSpecificationExecutor<Teacher>{
	
}
