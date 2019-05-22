package edu.mum.bloodbankrest.service.impl;

import edu.mum.bloodbankrest.dao.AddressDao;
import edu.mum.bloodbankrest.domain.Address;
import edu.mum.bloodbankrest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressDao addressDao;

    @Override
    public void save(Address address) {
       addressDao.save(address);
    }

    @Override
    public void update(Address address) {
        addressDao.update(address);
    }

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address findOne(Long id) {
        return addressDao.findOne(id);
    }
}
