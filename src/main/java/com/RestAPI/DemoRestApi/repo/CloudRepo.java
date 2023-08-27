package com.RestAPI.DemoRestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestAPI.DemoRestApi.model.CloudVendor;

public interface CloudRepo  extends JpaRepository<CloudVendor, Long>{

}
