package spring.mvc.study.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) Ŭ����
@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD ��� �޼ҵ�
	// ȸ�� ���
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Mybatis ������� getUser() ��� ó��");
		return (UserVO) mybatis.selectOne("userDAO.getUser",vo);
	}
}

