package cn.gmwenterprise.dubbo.repository;

import cn.gmwenterprise.dubbo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository extends BaseRepository<User> {
    @Override
    public void add(User user) {
        repository.put(increment(), user);
    }

    @Override
    public List<User> queryAll() {
        return new ArrayList<>(repository.values());
    }
}
