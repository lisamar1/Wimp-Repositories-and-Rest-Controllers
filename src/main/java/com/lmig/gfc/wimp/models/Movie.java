package com.lmig.gfc.wimp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity
	public class Movie {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@Column(length=300, nullable=false)
		private String title;
		
		@Column(nullable=true)
		private Long releaseDate; 
		
		@Column(nullable=true)		
		private Long budget;
		
		@Column(length=500, nullable=false)
		private String distributor;

		public Movie() {
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id2) {
			this.id = id2;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Long getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(Long releaseDate) {
			this.releaseDate = releaseDate;
		}

		public Long getBudget() {
			return budget;
		}

		public void setBudget(Long budget) {
			this.budget = budget;
		}

		public String getDistributor() {
			return distributor;
		}

		public void setDistributor(String distributor) {
			this.distributor = distributor;
		}


}
