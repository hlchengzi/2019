package com.example.AiLab.repository;

import com.example.AiLab.domain.Lab;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by jing on 2017/7/4.
 */
@Repository
public interface LabRepository extends JpaRepository<Lab,Long>{


}
