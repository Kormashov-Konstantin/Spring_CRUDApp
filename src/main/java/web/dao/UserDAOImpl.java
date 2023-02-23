package web.dao;

import org.springframework.context.annotation.Primary;
import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Primary
    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from users ", User.class).getResultList();
    }

    @Override
    public User oneUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
        entityManager.flush();

    }

    @Override
    public void removeUserById(int id) {
        User user = oneUser(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
    }
}




