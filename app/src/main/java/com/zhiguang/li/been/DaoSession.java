package com.zhiguang.li.been;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.zhiguang.li.been.User;
import com.zhiguang.li.been.Dog;

import com.zhiguang.li.been.UserDao;
import com.zhiguang.li.been.DogDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig dogDaoConfig;

    private final UserDao userDao;
    private final DogDao dogDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        dogDaoConfig = daoConfigMap.get(DogDao.class).clone();
        dogDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        dogDao = new DogDao(dogDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Dog.class, dogDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        dogDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DogDao getDogDao() {
        return dogDao;
    }

}
