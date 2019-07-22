package usejdbc.service;

import usejdbc.bean.User;
import usejdbc.dao.UserDAO;

public class UserService {

    private static UserDAO userDAO;

    static {
        userDAO = new UserDAO();
    }

    /**
     * 从数据库中得到用户信息
     * @param username
     * @param password
     * @return
     */
    public static User login(String username, String password) {
        return userDAO.login(username, password);//直接调用方法似乎也可有
    }

    /**
     * 通过id来获取用户的信息
     * @param id
     * @return
     */
    public static User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    /**
     * 只更新不查询
     * @param user
     * @return
     */
    public static boolean updateUser(User user) {
        return userDAO.updataUser(user);
    }
}
