package com.lmig.gfc.wimp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository <Movie, String> {

}
