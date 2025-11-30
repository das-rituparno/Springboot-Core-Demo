package SpringBootCache.Cache.Service;

import SpringBootCache.Cache.Model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> database = new HashMap<>();

    public UserService() {
        database.put(1, new User(1, "Ritu"));
        database.put(2, new User(2, "Dwitiya"));
    }
    
    @Cacheable(value = "users", key = "#id")
    public User getUser(int id) {
        System.out.println(">> Fetching from DB...");
        return database.get(id);
    }

    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        System.out.println(">> Updating user in DB...");
        database.put(user.getId(), user);
        return user;
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(int id) {
        System.out.println(">> Deleting user from DB...");
        database.remove(id);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void clearCache() {
        System.out.println(">> Clearing entire user cache...");
    }
}
