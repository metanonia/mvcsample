package com.metanonia.mvcsample.repository;

import com.metanonia.mvcsample.model.Depth;
import com.metanonia.mvcsample.model.DepthId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepthRepository extends JpaRepository<Depth, DepthId> {
}
