package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.DonorDao;
import edu.mum.bloodbankrest.dao.GenericDao;
import edu.mum.bloodbankrest.domain.BloodType;
import edu.mum.bloodbankrest.domain.Donor;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;


@SuppressWarnings("unchecked")
@Repository
public class DonorDaoImpl extends GenericDaoImpl<Donor> implements DonorDao {
    DonorDaoImpl(){
        super.setDaoType(Donor.class);
    }

    public Integer findByBloodType(BloodType bloodType) {
//        ong x=bloodType.getId();
//          Query query =  entityManager.createNativeQuery("SELECT count(*) as Total FROM donor where age=:x");
//        Query x1 = query.setParameter("x", x);
//
//         Integer singleResult = (Integer) x1.getSingleResult();
//        return singleResult;

       return null;

    }
}
