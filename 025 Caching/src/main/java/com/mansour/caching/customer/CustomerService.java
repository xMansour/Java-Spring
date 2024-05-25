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
// @CacheConfig(cacheNames = "customerCache")
public class CustomerService implements BaseService<Customer, Long> {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Caching(cacheable = {
            @Cacheable(cacheNames = "customersCache", key = "#root.methodName", cacheManager = "caffeineCacheManager"),
            @Cacheable(cacheNames = "customersCache", key = "#root.methodName", cacheManager = "redisCacheManager")
    })

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Caching(cacheable = {
            @Cacheable(cacheNames = "customerCache", key = "#id", cacheManager = "caffeineCacheManager"),
            @Cacheable(cacheNames = "customerCache", key = "#id", cacheManager = "redisCacheManager")
    })
    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id:%s not found.".formatted(id)));
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = "customersCache", allEntries = true, cacheManager = "caffeineCacheManager"),
            @CacheEvict(cacheNames = "customersCache", allEntries = true, cacheManager = "redisCacheManager") })
    @Override
    public Customer create(Customer obj) {
        return customerRepository.save(obj);
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = "customersCache", allEntries = true, cacheManager = "caffeineCacheManager"),
            @CacheEvict(cacheNames = "customersCache", allEntries = true, cacheManager = "redisCacheManager") }, put = {
                    @CachePut(cacheNames = "customerCache", key = "#obj.id", cacheManager = "caffeineCacheManager"),
                    @CachePut(cacheNames = "customerCache", key = "#obj.id", cacheManager = "redisCacheManager") })
    @Override
    public Customer update(Customer obj) {
        return customerRepository.save(obj);
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = "customersCache", allEntries = true, cacheManager = "caffeineCacheManager"),
            @CacheEvict(cacheNames = "customerCache", key = "#id", cacheManager = "caffeineCacheManager"),
            @CacheEvict(cacheNames = "customersCache", allEntries = true, cacheManager = "redisCacheManager"),
            @CacheEvict(cacheNames = "customerCache", key = "#id", cacheManager = "redisCacheManager") })
    @Override
    public Customer delete(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id:%s not found.".formatted(id)));
        customerRepository.deleteById(id);
        return customer;
    }

}
