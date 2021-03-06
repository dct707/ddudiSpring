package spring.mvc.study.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 클래스
@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD 기능 메소드
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Mybatis 기반으로 getUser() 기능 처리");
		return (UserVO) mybatis.selectOne("userDAO.getUser",vo);
	}
}

