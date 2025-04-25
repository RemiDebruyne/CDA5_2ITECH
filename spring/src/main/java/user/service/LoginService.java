package user.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.model.User;
import user.repository.UserRepository;

@Service
public class LoginService {
    private final HttpSession session;
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository,HttpSession session) {
        this.userRepository = userRepository;
        this.session = session;
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            return null;
        }

        if(user.getPassword().equals(password)){
            session.setAttribute("isLoggedIn", user.getId());
            return user;
        }

        return null;
    }

    public User isLoggedIn() {
        if(session.getAttribute("isLoggedIn") != null) {
            int userId =  (int)session.getAttribute("isLoggedIn");
            return userRepository.findById(userId).get();
        }
        return null;
    }

    public void logout() {
        session.invalidate();
    }
}
