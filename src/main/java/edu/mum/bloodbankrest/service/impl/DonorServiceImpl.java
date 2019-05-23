package edu.mum.bloodbankrest.service.impl;

import edu.mum.bloodbankrest.dao.BloodTypeDao;
import edu.mum.bloodbankrest.dao.DonationDao;
import edu.mum.bloodbankrest.dao.DonorDao;
import edu.mum.bloodbankrest.domain.BloodType;
import edu.mum.bloodbankrest.domain.Donation;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.domain.Total;
import edu.mum.bloodbankrest.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {

     @Autowired
     private DonorDao donorDao;
     @Autowired
     private DonationDao donationDao;
     @Autowired
     private BloodTypeDao bloodTypeDao;

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
    public List<Total> findAvailableBloodType() {


        //  List<Donor> donors=donorDao.findAll();
        List<Total> avaliableBlood=new ArrayList<>();
        List<Donation> donations = donationDao.findAll();
        List<BloodType> bloodTypes = bloodTypeDao.findAll();
        for (BloodType blood : bloodTypes) {
            Integer sum = 0;
            for (Donation donation : donations) {
                if (donation.getDonor().getBloodType().getId().equals(blood.getId())) {
                    sum += donation.getQuantity();
                }
            }
            Total total=new Total();
                total.setTotal(sum);
                total.setName(blood.getName());
                avaliableBlood.add(total);
        }
         return avaliableBlood;

    }

    @Override
    public Donor findOne(Long id) {
        return donorDao.findOne(id);
    }
}
