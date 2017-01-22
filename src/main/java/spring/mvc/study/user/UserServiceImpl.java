package spring.mvc.study.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 4. Service ���� Ŭ����
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}