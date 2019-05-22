package edu.mum.bloodbankrest.service.impl;

import edu.mum.bloodbankrest.dao.DonationDao;
import edu.mum.bloodbankrest.domain.Donation;
import edu.mum.bloodbankrest.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DonationServiceImpl implements DonationService {

     @Autowired
    private DonationDao donationDao;
    @Override
    public void save(Donation donation) {
        donationDao.save(donation);
    }

    @Override
    public void update(Donation donation) {
         donationDao.update(donation);
    }

    @Override
    public List<Donation> findAll() {
        return donationDao.findAll();
    }

    @Override
    public Donation findOne(Long id) {
        return donationDao.findOne(id);
    }
}
