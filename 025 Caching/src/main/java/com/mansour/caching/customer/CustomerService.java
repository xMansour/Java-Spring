package com.mansour.caching.customer;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.mansour.caching.shared.base.BaseService;

import jakarta.persistence.EntityNotFoundException;

@Service
@CacheConfig(cacheNames = "customerCache")
public class CustomerService implements BaseService<Customer, Long> {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Caching(cacheable = {
            @Cacheable(cacheManager = "caffeineCacheManager"),
            @Cacheable(cacheManager = "redisCacheManager")
    })
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Caching(cacheable = {
            @Cacheable(cacheManager = "caffeineCacheManager"),
            @Cacheable(cacheManager = "redisCacheManager")
    })
    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id:%s not found.".formatted(id)));
    }

    @Caching(cacheable = {
            @Cacheable(cacheManager = "caffeineCacheManager"),
            @Cacheable(cacheManager = "redisCacheManager")
    })
    @Override
    public Customer create(Customer obj) {
        return customerRepository.save(obj);
    }

    @Caching(put = {
            @CachePut(cacheManager = "caffeineCacheManager"),
            @CachePut(cacheManager = "redisCacheManager")
    })
    @Override
    public Customer update(Customer obj) {
        return customerRepository.save(obj);
    }

    @Caching(evict = {
            @CacheEvict(cacheManager = "caffeineCacheManager"),
            @CacheEvict(cacheManager = "redisCacheManager")
    })
    @Override
    public Customer delete(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id:%s not found.".formatted(id)));
        customerRepository.deleteById(id);
        return customer;
    }

}
