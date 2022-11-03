package com.example.api.custom.query2.repositories;

import com.example.api.custom.query2.entities.Fligth;
import com.example.api.custom.query2.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FligthRepository extends JpaRepository<Fligth,Long> {

    @Query("SELECT f FROM Fligth f where f.status = ?1 AND f.status = ?2 ")
    public List<Fligth> findByStatus(Status status, Status status1);
}
