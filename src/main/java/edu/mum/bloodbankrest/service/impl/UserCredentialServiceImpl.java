package edu.mum.bloodbankrest.service.impl;

import edu.mum.bloodbankrest.dao.UserCredentialDao;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserCredentialServiceImpl implements UserCredentialsService {
    @Autowired
    private UserCredentialDao userCredentialDao;


    public void save( UserCredentials userCredentials) {
        userCredentialDao.save(userCredentials);
    }


    public List<UserCredentials> findAll() {
        return (List<UserCredentials>)userCredentialDao.findAll();
    }

    public UserCredentials findByUserName(String userName) {
        return userCredentialDao.findByUserName(userName);
    }


    @Override
    public UserCredentials update(UserCredentials userCredentials) {
        return userCredentialDao.update(userCredentials);

    }
}
