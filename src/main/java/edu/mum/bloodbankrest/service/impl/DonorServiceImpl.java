package edu.mum.bloodbankrest.service.impl;

import edu.mum.bloodbankrest.dao.DonorDao;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {

     @Autowired
     private DonorDao donorDao;

    @Override
    public void save(Donor donor) {
         donorDao.save(donor);
    }

    @Override
    public void update(Donor donor) {
        donorDao.update(donor);
    }

    @Override
    public List<Donor> findAll() {
        return donorDao.findAll();
    }

    @Override
    public Donor findOne(Long id) {
        return donorDao.findOne(id);
    }
}
